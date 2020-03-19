package tseringer.boris.sfgpetclinicpetproject.services;

import tseringer.boris.sfgpetclinicpetproject.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findBySecondName(String secondName);
}
