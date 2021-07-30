package com.example.sit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

     @Autowired
     private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm(){
        return "contact_form";
    }

    @PostMapping("/contact")
    public String submitContact(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("question") String question)
    {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kucheriavyi.ilya@gmail.com ");
        message.setTo("kosenkov_shura@list.ru ");

        String mailSubject = name + " отправил вам сообщение";
        String mailContent = "Имя отправителя: " + name + "\n";
        mailContent += "E-mail отправителя: " + email + "\n";
        mailContent += "Телефон отправителя: " + phone + "\n";
        mailContent += "Вопрос: " + question + "\n";

        message.setSubject(mailSubject);
        message.setText(mailContent);

        mailSender.send(message);

        return "message";
   }
}
