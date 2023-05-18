package com.codeup.codeupspringblog;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {


    @GetMapping(path = "/roll-dice")
    public String rollDice() {
        return "guessNum";
    }
    @GetMapping(path="/roll-dice/{n}")
    public String numGenerated(@PathVariable int n, Model model){
        int randomNumber = (int)Math.floor(Math.random() * (6 - 1 + 1) + 1);
        String guess = "";

        if(randomNumber == n){
           guess = "You got it";
        } else {
            guess = "Try again.";
        }

        model.addAttribute("userGuess", "Your guess is: " + n);
        model.addAttribute("diceRoll", "The die rolled: " + randomNumber);
        model.addAttribute("guess", guess);
        return "guessNum";
    }
}
