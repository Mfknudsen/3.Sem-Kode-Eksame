package entities;

import javax.persistence.*;

@Entity
public class Boat {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String Brand;
    @Column
    private String Make;
    @Column
    private String Year;
    @Column
    private String ImageURL;

    public Boat() {
    }

    public Boat(String name, String brand, String make, String year, String imageURL) {
        this.name = name;
        Brand = brand;
        Make = make;
        Year = year;
        ImageURL = imageURL;
    }
}
