package facades;

import dtos.BoatDTO;
import entities.Boat;
import interfaces.IFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BoatFacade implements IFacade<BoatDTO> {
    private static EntityManagerFactory emf;
    private static BoatFacade instance;

    public BoatFacade() {
    }

    public static BoatFacade getBoatFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }

        return instance;
    }

    @Override
    public BoatDTO create(BoatDTO dto) {
        EntityManager em = emf.createEntityManager();
        Boat boat = new Boat(
                dto.getName(),
                dto.getBrand(),
                dto.getMake(),
                dto.getYear(),
                dto.getUrl()
        );
        em.getTransaction().begin();
        em.persist(boat);
        em.getTransaction().commit();
        return dto;
    }

    public List<BoatDTO> getByOwned(long id) {
        EntityManager em = emf.createEntityManager();
        List<BoatDTO> result = BoatDTO.getDTOs(em.createQuery("select b from Boat b where b.ownerID=" + id, Boat.class).getResultList());
        em.close();
        return result;
    }

    public void updateOwner(long boatID, long ownerID) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.createNamedQuery("update backend.OWNER_BOAT set backend.OWNER_BOAT.Owner_ID =" + ownerID + " where backend.OWNER_BOAT.boats_ID =" + boatID).executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(BoatDTO dto) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            if (!dto.getName().equals(""))
                em.createQuery("update Boat b set b.name=" + dto.getName() + " where b.id=" + dto.getId(), Boat.class).executeUpdate();

            if (!dto.getBrand().equals(""))
                em.createQuery("update Boat b set b.Brand=" + dto.getBrand() + " where b.id=" + dto.getId()).executeUpdate();

            if (!dto.getMake().equals(""))
                em.createQuery("update Boat b set b.Make=" + dto.getMake() + " where b.id=" + dto.getId()).executeUpdate();

            if (!dto.getYear().equals(""))
                em.createQuery("update Boat b set b.Year=" + dto.getYear() + " where b.id=" + dto.getId()).executeUpdate();

            if (!dto.getUrl().equals(""))
                em.createQuery("update Boat b set b.ImageURL=" + dto.getUrl() + " where b.id=" + dto.getId()).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public BoatDTO getById(long id) {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public List<BoatDTO> getAll() {
        return null;
    }

    @Override
    public List<BoatDTO> getSpecific(String valueType, String value) {
        return null;
    }
}
