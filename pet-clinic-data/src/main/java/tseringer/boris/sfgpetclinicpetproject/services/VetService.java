package tseringer.boris.sfgpetclinicpetproject.services;

public interface Vet extends CrudService<Vet, Long> {
    Vet findBySecondName(String secondName);
}
