package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    @GetMapping(path = "/posts/add")
    public String createFormRoute(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @PostMapping(path = "/posts/create")
//    public String createThePostRoute(@ModelAttribute Post post) {
//        post.setUser(userDao.getReferenceById(1L));
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping(path = "/posts/{id}/edit")
    public String editGet(Model model, @PathVariable Long id) {
        Post post = postDao.findById(id).get();

        model.addAttribute("post", post);

        return "posts/create";
    }

    @GetMapping(path = "/posts/email/{id}")
    public String sendEmailAboutPost(@PathVariable Long id){
        Post post = postDao.getReferenceById(id);
         emailService.prepareAndSend(post, "Post inquiry information.", post.getTitle() + " : " + post.getBody() + " — was posted by: " + post.getUser().getUsername());
         return "redirect:/posts";
    }


}
