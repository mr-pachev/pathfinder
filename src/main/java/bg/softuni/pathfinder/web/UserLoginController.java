package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
    @GetMapping("/users/login")
    public String viewLoginUser(){

        return "login";
    }

    @GetMapping("users/login-error")
    public String viewLoginError(Model model) { 	model.addAttribute("showErrorMessage", true); 	model.addAttribute("loginData", new UserLoginDTO());
        return "login";
    }

}
