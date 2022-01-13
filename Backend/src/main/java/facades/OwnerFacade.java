package facades;

import dtos.OwnerDTO;
import interfaces.IFacade;

import java.util.List;

public class OwnerFacade implements IFacade<OwnerDTO> {
    @Override
    public OwnerDTO create(OwnerDTO classDTO) {
        return null;
    }

    @Override
    public OwnerDTO getById(long id) {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public List<OwnerDTO> getAll() {
        return null;
    }

    @Override
    public List<OwnerDTO> getSpecific(String valueType, String value) {
        return null;
    }
}
