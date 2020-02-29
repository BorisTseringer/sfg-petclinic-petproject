package tseringer.boris.sfgpetclinicpetproject.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tseringer.boris.sfgpetclinicpetproject.model.*;
import tseringer.boris.sfgpetclinicpetproject.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired // required in Spring 4
    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();
        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("dog");
        petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("cat");
        petTypeService.save(catPetType);

        Specialty radiologist = new Specialty();
        radiologist.setDescription("radiologist");
        specialtyService.save(radiologist);

        Specialty dentist = new Specialty();
        dentist.setDescription("dentist");
        specialtyService.save(dentist);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtyService.save(surgery);

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
        vet1.getSpecialities().add(surgery);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Bodya");
        vet2.setLastName("Bodyanov");
        vet2.getSpecialities().add(dentist);
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
