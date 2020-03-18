package tseringer.boris.sfgpetclinicpetproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tseringer.boris.sfgpetclinicpetproject.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
