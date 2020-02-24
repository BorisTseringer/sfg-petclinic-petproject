package tseringer.boris.sfgpetclinicpetproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tseringer.boris.sfgpetclinicpetproject.model.Owner;
import tseringer.boris.sfgpetclinicpetproject.model.Vet;
import tseringer.boris.sfgpetclinicpetproject.services.map.OwnerMapService;
import tseringer.boris.sfgpetclinicpetproject.services.map.PetMapService;
import tseringer.boris.sfgpetclinicpetproject.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerMapService ownerMapService;
    private final PetMapService petMapService;
    private final VetMapService vetMapService;

    public DataLoader() {
        ownerMapService = new OwnerMapService();
        petMapService = new PetMapService();
        vetMapService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ivan");
        owner1.setLastName("Ivanov");
        ownerMapService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner1.setFirstName("Petr");
        owner1.setLastName("Petrov");
        ownerMapService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Evegen");
        vet1.setLastName("Badcom");
        vetMapService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Bodya");
        vet1.setLastName("Bodyanov");
        vetMapService.save(vet2);

        System.out.println("Loaded vets...");


     }
}
