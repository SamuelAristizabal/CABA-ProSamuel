
package com.caba.CABA_Pro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Nombre de método a ejecutar en esa dirección
    public String index(Model model) {
        model.addAttribute("title", "Welcome to Spring Boot");
        model.addAttribute("subtitle", "An Spring Boot Eafit App");
        return "home/index"; // Dirección de una vista a la que me voy a dirigir

    }

    //@GetMapping("/form")
    //public String form(Model model) {
//
    //    model.addAttribute("title", "About Us - Online Store");
    //    model.addAttribute("subtitle", "About Us");
    //    model.addAttribute("description", "This is an about page ...");
    //    model.addAttribute("author", "Developed by: Your Name");
    //    return "home/form";
//
    //}


}
    