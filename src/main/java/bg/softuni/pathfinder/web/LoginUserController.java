package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginUserController {
    @GetMapping("/users/login")
    public String viewLoginUser(){

        return "login";
    }
}
