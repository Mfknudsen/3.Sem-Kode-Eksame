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

    @OneToOne
    private Owner owner;
    @OneToOne
    private Auction auction;

    public Boat() {
    }

    public Boat(String name, String brand, String make, String year, String imageURL) {
        this.name = name;
        Brand = brand;
        Make = make;
        Year = year;
        ImageURL = imageURL;
    }

    public long getOwnerID() {
        return owner.getId();
    }

    public long getAuctionID() {
        return auction.getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return Brand;
    }

    public String getMake() {
        return Make;
    }

    public String getYear() {
        return Year;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
