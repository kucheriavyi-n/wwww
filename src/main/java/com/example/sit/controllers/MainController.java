package com.example.sit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Главная страница");
        return "index";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Главная страница");
        return "about";
    }
    @GetMapping("/clients")
    public String clients(Model model) {
        model.addAttribute("title", "Главная страница");
        return "clients";
    }
    @GetMapping("/location")
    public String location(Model model) {
        model.addAttribute("title", "Главная страница");
        return "location";
    }
    @GetMapping("/system")
    public String system(Model model) {
        model.addAttribute("title", "Главная страница");
        return "system";
    }
    @GetMapping("/banking")
    public String banking(Model model) {
        model.addAttribute("title", "Главная страница");
        return "banking";
    }
    @GetMapping("notif")
    public String notif(Model model) {
        model.addAttribute("title", "Главная страница");
        return "notif";
    }

}