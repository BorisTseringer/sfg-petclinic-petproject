package tseringer.boris.sfgpetclinicpetproject.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;
import tseringer.boris.sfgpetclinicpetproject.model.Pet;
import tseringer.boris.sfgpetclinicpetproject.model.PetType;
import tseringer.boris.sfgpetclinicpetproject.model.Vet;
import tseringer.boris.sfgpetclinicpetproject.services.OwnerService;
import tseringer.boris.sfgpetclinicpetproject.services.PetService;
import tseringer.boris.sfgpetclinicpetproject.services.PetTypeService;
import tseringer.boris.sfgpetclinicpetproject.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired // required in Spring 4
    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogPetType = new PetType();
        dogPetType.setName("dog");
        petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("cat");
        petTypeService.save(catPetType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ivan");
        owner1.setLastName("Ivanov");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Petr");
        owner2.setLastName("Petrov");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Evegen");
        vet1.setLastName("Badcom");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bodya");
        vet2.setLastName("Bodyanov");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

        Pet pet1 = new Pet();
        pet1.setName("Jack");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType(dogPetType);
        owner1.getPets().add(pet1);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Dive");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        pet2.setPetType(catPetType);
        owner2.getPets().add(pet2);
        petService.save(pet2);

     }
}
