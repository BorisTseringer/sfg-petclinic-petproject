package tseringer.boris.sfgpetclinicpetproject.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;
    String lastName = "Steve";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner = Owner.builder().id(ownerId).lastName("Steve").build();
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(owner.getId(), ownerId);

    }

    @Test
    void saveExistedId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void noIdSave(){
        Owner owner = Owner.builder().build();

        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findBySecondName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void secondNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);

    }
}