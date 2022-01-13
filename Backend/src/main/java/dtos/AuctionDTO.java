package dtos;

import entities.Auction;
import interfaces.Idto;

import java.util.ArrayList;
import java.util.List;

public class AuctionDTO implements Idto<AuctionDTO, Auction> {
    private long id;
    private String name, date, time, location;

    public AuctionDTO() {
    }

    public AuctionDTO(long id, String name, String date, String time, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public static List<AuctionDTO> getDTOs(List<Auction> list) {
        List<AuctionDTO> result = new ArrayList<>();

        for (Auction auction : list) {
            AuctionDTO dto = new AuctionDTO(
                    auction.getId(),
                    auction.getName(),
                    auction.getDate(),
                    auction.getTime(),
                    auction.getLocation()
            );
            result.add(dto);
        }

        return result;
    }
}
