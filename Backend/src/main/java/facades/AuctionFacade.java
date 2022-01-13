package facades;

import dtos.AuctionDTO;
import interfaces.IFacade;

import java.util.List;

public class AuctionFacade implements IFacade<AuctionDTO> {
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
        return null;
    }

    @Override
    public List<AuctionDTO> getSpecific(String valueType, String value) {
        return null;
    }
}
