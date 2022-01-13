package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany()
    private List<Boat> boats;

    public Owner() {
    }

    public Owner(String name, String phone, String email, List<Boat> boats) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.boats = boats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
