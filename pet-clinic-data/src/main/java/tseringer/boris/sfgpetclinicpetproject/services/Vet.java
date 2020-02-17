package tseringer.boris.sfgpetclinicpetproject.services;

import java.util.Set;

public interface Vet {
    Vet findById(Long id);
    Vet findBySecondName(String secondName);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
