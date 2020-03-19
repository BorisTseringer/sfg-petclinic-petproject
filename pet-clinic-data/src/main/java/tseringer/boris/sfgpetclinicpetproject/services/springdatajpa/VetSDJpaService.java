package tseringer.boris.sfgpetclinicpetproject.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tseringer.boris.sfgpetclinicpetproject.model.Vet;
import tseringer.boris.sfgpetclinicpetproject.repositories.SpecialtyRepository;
import tseringer.boris.sfgpetclinicpetproject.repositories.VetRepository;
import tseringer.boris.sfgpetclinicpetproject.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;


    public VetSDJpaService(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Vet findBySecondName(String secondName) {
        return vetRepository.findByLastName(secondName);
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets =  new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
