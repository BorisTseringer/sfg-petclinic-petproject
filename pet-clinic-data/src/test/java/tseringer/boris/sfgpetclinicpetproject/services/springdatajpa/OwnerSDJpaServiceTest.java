package tseringer.boris.sfgpetclinicpetproject.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;
import tseringer.boris.sfgpetclinicpetproject.repositories.OwnerRepository;
import tseringer.boris.sfgpetclinicpetproject.repositories.PetRepository;
import tseringer.boris.sfgpetclinicpetproject.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String SECOND_NAME = "Steve";
    public static final long ID = 1L;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).lastName(SECOND_NAME).build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.findByLastName(SECOND_NAME);

        assertEquals(SECOND_NAME, owner.getLastName());


    }

    @Test
    void findById() {

        when(ownerRepository.findById(ID)).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(ID);
        assertNotNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner owner = ownerSDJpaService.save(Owner.builder().build());

        assertNotNull(owner);

    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {

        ownerSDJpaService.delete(Owner.builder().build());
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ID);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}