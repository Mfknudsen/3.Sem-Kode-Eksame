package dtos;

import entities.Owner;
import interfaces.Idto;

import java.util.List;

public class OwnerDTO implements Idto<OwnerDTO, Owner> {
    String name, phone, email;
    List<BoatDTO> boats;

    public OwnerDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
