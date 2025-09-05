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

    @GetMapping("/form")
    public String form(Model model) {

        model.addAttribute("title", "About Us - Online Store");
        model.addAttribute("subtitle", "About Us");
        model.addAttribute("description", "This is an about page ...");
        model.addAttribute("author", "Developed by: Your Name");
        return "home/form";

    }

    @GetMapping("/productList")
    public String productList(Model model) {

        model.addAttribute("title", "Contacto - Online Store");

        // Información de contacto dinámica
        model.addAttribute("email", "info@miempresa.com");
        model.addAttribute("phone", "+57 300 123 4567");
        model.addAttribute("address", "Cra. 49 #7 Sur-50, Medellín, Colombia");

        // Links de redes sociales
        model.addAttribute("facebook", "https://facebook.com/miempresa");
        model.addAttribute("twitter", "https://twitter.com/miempresa");
        model.addAttribute("instagram", "https://instagram.com/miempresa");

        return "home/productList";
    }

}