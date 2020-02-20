package tseringer.boris.sfgpetclinicpetproject.services;

public interface VetService extends CrudService<VetService, Long> {
    VetService findBySecondName(String secondName);
}
