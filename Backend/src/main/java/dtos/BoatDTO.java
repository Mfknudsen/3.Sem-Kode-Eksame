package dtos;

import entities.Boat;
import interfaces.Idto;

import java.util.ArrayList;
import java.util.List;

public class BoatDTO implements Idto<BoatDTO, Boat> {
    long id, owner, auction;

    String name, brand, make, year, url;

    public BoatDTO(long owner, long auction,String name, String brand, String make, String year, String url) {
        this.owner = owner;
        this.auction = auction;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
        this.url = url;
    }

    public static List<BoatDTO> getDTOs(List<Boat> list) {
       List<BoatDTO> result = new ArrayList<>();

        for (Boat boat : list) {
            result.add(new BoatDTO(
                    boat.getOwnerID(),
                    boat.getAuctionID(),
                    boat.getName(),
                    boat.getBrand(),
                    boat.getMake(),
                    boat.getYear(),
                    boat.getImageURL()
                    ));
        }

       return result;
    }

    public long getOwner() {
        return owner;
    }

    public long getAuction() {
        return auction;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getMake() {
        return make;
    }

    public String getYear() {
        return year;
    }

    public String getUrl() {
        return url;
    }
}
