package dtos;

import entities.Boat;
import interfaces.Idto;

public class BoatDTO implements Idto<BoatDTO, Boat> {
    long id;

    String name, brand, make, year, url;

    public BoatDTO(String name, String brand, String make, String year, String url) {
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
        this.url = url;
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
