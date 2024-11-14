package com.k1fl1k.mvcarchitecture.controller;

import com.k1fl1k.mvcarchitecture.dto.PostDTO;
import com.k1fl1k.mvcarchitecture.model.Post;
import com.k1fl1k.mvcarchitecture.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(@RequestParam(defaultValue = "0") int page, Model model) {
        List<PostDTO> posts = postService.getAllPosts(page);
        model.addAttribute("posts", posts);
        return "list";
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        PostDTO post = postService.getPostById(id);
        if (post == null) {
            return "404";
        }
        model.addAttribute("post", post);
        return "view";
    }

    @GetMapping("/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "form";
    }

    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("post") PostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "form"; // Return to form with errors
        }
        postService.createOrUpdatePost(postDTO);
        return "redirect:/posts"; // Redirect to the list of posts
    }

    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable Long id, Model model) {
        PostDTO post = postService.getPostById(id);
        if (post == null) {
            return "404"; // Handle not found
        }
        model.addAttribute("post", post);
        return "form"; // Name of your HTML template
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, @Valid @ModelAttribute("post") PostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "form"; // Return to form with errors
        }
        postDTO.setId(id);
        postService.createOrUpdatePost(postDTO);
        return "redirect:/posts"; // Redirect to the list of posts
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts"; // Redirect to the list of posts
    }
}