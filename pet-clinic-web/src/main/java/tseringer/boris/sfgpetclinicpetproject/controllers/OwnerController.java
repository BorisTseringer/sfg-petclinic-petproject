package tseringer.boris.sfgpetclinicpetproject.controllers;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tseringer.boris.sfgpetclinicpetproject.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index", "/index.html"})
    String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    String findOwners(Model model){
        return "owners/notimplemented";
    }
}
