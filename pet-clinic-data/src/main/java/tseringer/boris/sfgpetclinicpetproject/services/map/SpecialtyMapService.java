package tseringer.boris.sfgpetclinicpetproject.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tseringer.boris.sfgpetclinicpetproject.model.Specialty;
import tseringer.boris.sfgpetclinicpetproject.services.SpecialtyService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }
}
