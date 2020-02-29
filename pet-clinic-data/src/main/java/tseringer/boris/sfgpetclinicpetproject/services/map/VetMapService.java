package tseringer.boris.sfgpetclinicpetproject.services.map;

import org.springframework.stereotype.Service;
import tseringer.boris.sfgpetclinicpetproject.model.Specialty;
import tseringer.boris.sfgpetclinicpetproject.model.Vet;
import tseringer.boris.sfgpetclinicpetproject.services.SpecialtyService;
import tseringer.boris.sfgpetclinicpetproject.services.VetService;

import java.util.Set;
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialities().size() > 0){
            vet.getSpecialities().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public VetService findBySecondName(String secondName) { //TODO
        return null;
    }
}
