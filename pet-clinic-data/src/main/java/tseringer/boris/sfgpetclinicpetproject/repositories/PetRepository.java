package tseringer.boris.sfgpetclinicpetproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tseringer.boris.sfgpetclinicpetproject.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
