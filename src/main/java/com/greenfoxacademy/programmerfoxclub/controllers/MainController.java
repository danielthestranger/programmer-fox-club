package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.utils.UriUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex(HttpServletRequest request,
                            @RequestParam(value = "name", required = false, defaultValue = "") String name,
                            Model model) {
        if (request.getQueryString() == null
                || request.getQueryString().isEmpty()
                || name.isEmpty()) {
            return "redirect:/login";
        }
        //TODO validate input name param - exists -> redirect to login with error message
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @RequestParam("name") String name) {
        //input @RequestParam is not used, it's only there to enforce its presence
        String uriQuery = UriUtil.queryFromRequestParamMap(request.getParameterMap());
        return "redirect:/" + uriQuery;
    }

}
