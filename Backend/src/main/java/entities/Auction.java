package entities;

import javax.persistence.*;
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

    @OneToMany
    private List<Boat> boats;
}
