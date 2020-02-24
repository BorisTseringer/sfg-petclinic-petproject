package tseringer.boris.sfgpetclinicpetproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"owners", "owners/index", "owners/index.html"})
    String index(){

        return "owners/index";
    }
}
