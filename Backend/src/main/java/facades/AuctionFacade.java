package facades;

import dtos.AuctionDTO;
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

    public static AuctionFacade getAuctionFacade(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new AuctionFacade();
        }

        return instance;
    }

    @Override
    public AuctionDTO create(AuctionDTO classDTO) {
        return null;
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
