package io.github.faizansaghir.springMVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/show-form")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {

        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String message = "Yo! "+name;

        model.addAttribute("message", message);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam(name = "studentName") String name,
            Model model
    ) {
        name = name.toUpperCase();

        String message = "Hey my friend! "+name;

        model.addAttribute("message", message);

        return "helloworld";
    }

}
