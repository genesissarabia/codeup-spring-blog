package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class MathController {

    @RequestMapping(path ="/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y){
        return String.valueOf(x+y);
    }
    @RequestMapping(path="/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y){
        return String.valueOf(y-x);
    }
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y){
        return String.valueOf(x*y);
    }
    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y){
        return String.valueOf(y/x);
    }
}
