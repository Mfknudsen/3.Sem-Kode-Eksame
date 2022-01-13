package entities;

import javax.persistence.*;
import javax.ws.rs.QueryParam;
import java.util.List;

@Entity
public class Auction {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String time;
    @Column
    private String location;

    public Auction() {
    }

    public Auction(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
}
