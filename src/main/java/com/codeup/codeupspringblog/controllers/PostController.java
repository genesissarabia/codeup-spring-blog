package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsRoute(Model model) {

        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String onePostRoute(@PathVariable Long id, Model model) {
        Post post = postDao.findById(id).get();
        post.getUser();

        model.addAttribute("newPost", post);
        return "posts/show";
    }
    @GetMapping(path = "/posts/create")
    public String createFormRoute(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping(path = "/posts/create")
    public String createThePostRoute(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }


}
