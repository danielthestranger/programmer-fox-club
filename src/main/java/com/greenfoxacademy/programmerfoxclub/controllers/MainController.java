package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.services.PetService;
import com.greenfoxacademy.programmerfoxclub.utils.UriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        String uriQuery = UriUtil.getFullUriQueryFromRequest(request);
        if (petService.exists(name)) {
            return "redirect:/information" + uriQuery;
        } else {
            return "redirect:/login" + uriQuery;
        }
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                      @RequestParam(value = "name", defaultValue = "") String name,
                        Model model) {
        String uriQuery = UriUtil.getFullUriQueryFromRequest(request);
        if (name.isEmpty()) {
            return "redirect:/login" + uriQuery;
        } else {
            petService.getByName(name);
            return "redirect:/information" + uriQuery;
        }
    }

    @GetMapping("/information")
    public String showInformationPage(HttpServletRequest request,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        String uriQuery = UriUtil.getFullUriQueryFromRequest(request);
        if (!validateNameParam(name)) {
            return "redirect:/login" + uriQuery;
        }
        model.addAttribute("pet", petService.getByName(name));
        return "information";
    }

    @GetMapping("/nutritionStore")
    public String showNutritionStore(HttpServletRequest request,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        String uriQuery = UriUtil.getFullUriQueryFromRequest(request);
        if (!validateNameParam(name)) {
            return "redirect:/login" + uriQuery;
        }
        model.addAttribute("pet", petService.getByName(name));
        return "nutrition-store";
    }

    private boolean validateNameParam(String name) {
        if (name.isEmpty() || !petExists(name))
            return false;
        else
            return true;
    }

    private boolean petExists(String name) {
        return petService.exists(name);
    }
}
