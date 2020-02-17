package tseringer.boris.sfgpetclinicpetproject.services;

import java.util.Set;

public interface Pet {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
