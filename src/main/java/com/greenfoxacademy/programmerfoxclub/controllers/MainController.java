package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.services.PetService;
import com.greenfoxacademy.programmerfoxclub.utils.UriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private PetService petService;

    @Autowired
    public MainController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/")
    public String showIndex(HttpServletRequest request,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        if (name.isEmpty() || !petExists(name)) {
            return "redirect:/login" + UriUtil.getFullUriQueryFromRequest(request);
        }

        model.addAttribute("name", name);
        return "index";
    }

    private boolean petExists(String name) {
        return petService.exists(name);
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                              @RequestParam("name") String name) {
        //input @RequestParam is not used, it's only there to enforce its presence
        String uriQuery = UriUtil.getFullUriQueryFromRequest(request);
        return "redirect:/" + uriQuery;
    }
}
