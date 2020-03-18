package tseringer.boris.sfgpetclinicpetproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
