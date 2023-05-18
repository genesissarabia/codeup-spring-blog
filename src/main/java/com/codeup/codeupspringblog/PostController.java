package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsRoute(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(2L, "Roxy Pup", "Roxy is my baby chihuahua. She's an angel and I love her to the sky and back!");
        Post post2 = new Post(3L, "Got a new lamp", "It's so pretty and it has floral print on the ceramic bottom. I got it at Hobby Lobby.");
        Post post3 = new Post(4L, "Love 2000s Latino Pop", "I'm on a 00's Latino Pop kick with specifically OV7, La Oreja De Van Gogh and Shakira :D");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("posts", posts);
        return "/posts/index";
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
