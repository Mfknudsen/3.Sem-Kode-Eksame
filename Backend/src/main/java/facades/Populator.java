/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Owner;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
/*
        fe.create(new RenameMeDTO(new Owner("First 1", "Last 1")));
        fe.create(new RenameMeDTO(new Owner("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new Owner("First 3", "Last 3")));
*/
    }
    
    public static void main(String[] args) {
        populate();
    }
}
