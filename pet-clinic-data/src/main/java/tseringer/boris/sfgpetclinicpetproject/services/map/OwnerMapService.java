package tseringer.boris.sfgpetclinicpetproject.services.map;

import org.springframework.stereotype.Service;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;
import tseringer.boris.sfgpetclinicpetproject.model.Pet;
import tseringer.boris.sfgpetclinicpetproject.services.OwnerService;
import tseringer.boris.sfgpetclinicpetproject.services.PetService;
import tseringer.boris.sfgpetclinicpetproject.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null){
            if(owner.getPets().size() > 0){ //my fix
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet must have Pet Type");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }


    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findBySecondName(String secondName) { //TODO
        return null;
    }
}
