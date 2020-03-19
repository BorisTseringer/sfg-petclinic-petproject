package tseringer.boris.sfgpetclinicpetproject.services.map;

import org.springframework.stereotype.Service;
import tseringer.boris.sfgpetclinicpetproject.model.Visit;
import tseringer.boris.sfgpetclinicpetproject.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService  {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }
}
