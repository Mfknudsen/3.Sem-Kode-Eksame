package facades;

import dtos.RenameMeDTO;
import entities.Owner;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;
import interfaces.IFacade;
import utils.EMF_Creator;

/**
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample implements IFacade<RenameMeDTO> {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private FacadeExample() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public RenameMeDTO create(RenameMeDTO rm) {
//        Owner rme = new Owner(rm.getDummyStr1(), rm.getDummyStr2());
        Owner rme = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RenameMeDTO(rme);
    }

    public RenameMeDTO getById(long id) { //throws RenameMeNotFoundException {
        EntityManager em = emf.createEntityManager();
        Owner rm = em.find(Owner.class, id);
//        if (rm == null)
//            throw new RenameMeNotFoundException("The RenameMe entity with ID: "+id+" Was not found");
        return new RenameMeDTO(rm);
    }

    //TODO Remove/Change this before use
    public long getRenameMeCount() {
        EntityManager em = getEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM Owner r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }
    }

    public List<RenameMeDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Owner> query = em.createQuery("SELECT r FROM Owner r", Owner.class);
        List<Owner> rms = query.getResultList();
        return RenameMeDTO.getDtos(rms);
    }

    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacadeExample(emf);
        fe.getAll().forEach(dto -> System.out.println(dto));
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public List<RenameMeDTO> getSpecific(String valueType, String value) {
        return null;
    }
}
