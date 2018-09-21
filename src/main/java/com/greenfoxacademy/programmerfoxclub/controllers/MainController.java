package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.utils.UriUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex(HttpServletRequest request,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            Model model) {
        if (name.isEmpty() || !petExists(name)) {
            return "redirect:/login" + UriUtil.getFullQueryFromRequest(request);
        }

        model.addAttribute("name", name);
        return "index";
    }

    private boolean petExists(String name) {
        // TODO implement
        return true;
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(value = "name", required = false) String name ) {
        //TODO implement error message in template if name has a value
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @RequestParam("name") String name) {
        //input @RequestParam is not used, it's only there to enforce its presence
        String uriQuery = UriUtil.getFullQueryFromRequest(request);
        return "redirect:/" + uriQuery;
    }

}
