package facades;

import dtos.BoatDTO;
import interfaces.IFacade;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BoatFacade implements IFacade<BoatDTO> {
    private static EntityManagerFactory emf;
    private static BoatFacade instance;

    public BoatFacade() {
    }

    public static BoatFacade getBoatFacade(EntityManagerFactory _emf) {
        if(instance == null){
            emf = _emf;
            instance = new BoatFacade();
        }

        return instance;
    }



    @Override
    public BoatDTO create(BoatDTO classDTO) {
        return null;
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
