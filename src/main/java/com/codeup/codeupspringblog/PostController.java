package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String postsRoute() {
        return "posts index page";
    }
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String onePostRoute(@PathVariable Long id, Model model) {
        Post newPost = new Post(1L, "Howdy!", "This is my first post! :)");
        model.addAttribute("newPost", newPost);
        return "posts/show";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createFormRoute() {
        return "view the form for creating a post";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createThePostRoute() {
        return "create a new post";
    }

}
