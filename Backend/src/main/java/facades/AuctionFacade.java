package facades;

import dtos.AuctionDTO;
import entities.Auction;
import interfaces.IFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AuctionFacade implements IFacade<AuctionDTO> {
    private static EntityManagerFactory emf;
    private static AuctionFacade instance;

    public AuctionFacade() {
    }

    public static AuctionFacade getAuctionFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AuctionFacade();
        }

        return instance;
    }

    public void DeleteByID(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Auction a where a.id =" + id);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public AuctionDTO create(AuctionDTO dto) {
        EntityManager em = emf.createEntityManager();
        Auction auction = new Auction(dto.getName(), dto.getDate(), dto.getTime(), dto.getLocation());
        em.getTransaction().begin();
        em.persist(auction);
        em.getTransaction().commit();

        return dto;
    }

    @Override
    public AuctionDTO getById(long id) {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public List<AuctionDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select a from Auction a");
        return AuctionDTO.getDTOs(q.getResultList());
    }

    @Override
    public List<AuctionDTO> getSpecific(String valueType, String value) {
        return null;
    }
}
