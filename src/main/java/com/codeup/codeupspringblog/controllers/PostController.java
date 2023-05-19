package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsRoute(Model model) {

        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String onePostRoute(@PathVariable Long id, Model model) {

        model.addAttribute("newPost", postDao.findById(id));
        return "posts/show";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createFormRoute() {
        return "posts/create";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createThePostRoute(@RequestParam("title") String title, @RequestParam("body") String body, Model model) {
        Post post = new Post(1L, title, body);
        model.addAttribute("post", postDao.save(post));
        return "redirect:/posts";
    }

}
