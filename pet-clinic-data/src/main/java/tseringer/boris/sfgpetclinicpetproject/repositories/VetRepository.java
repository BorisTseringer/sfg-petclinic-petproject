package tseringer.boris.sfgpetclinicpetproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tseringer.boris.sfgpetclinicpetproject.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
