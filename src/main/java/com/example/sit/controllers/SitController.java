package com.example.sit.controllers;

import com.example.sit.models.Post;
import com.example.sit.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Controller

public class SitController {


    @Autowired
    private PostRepository postRepository;
    @GetMapping("/sit")
    public String sitMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "sit-main";
    }

    @GetMapping("/sit/add")
    public String sitAdd(Model model) {
        return "sit-add";
    }
    @PostMapping("/sit/add")
    public String sitPostAdd(@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/sit";
    }
    @GetMapping("/sit/{id}")
    public String sitDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/sit";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "sit-details";
    }
    @GetMapping("/sit/{id}/edit")
    public String sitEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)) {
            return "redirect:/sit";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "sit-edit";
    }
    @PostMapping("/sit/{id}/edit")
    public String sitPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model){
        Post post;
        post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("No data!"));
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);

        return "redirect:/sit";
    }
}
