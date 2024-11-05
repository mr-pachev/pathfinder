package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserLoginController {
    @ModelAttribute("userLoginDTO")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/users/login")
    public String viewLoginUser(){

        return "login";
    }

    @GetMapping("users/login-error")
    public String viewLoginError(Model model) {
        model.addAttribute("showErrorMessage", true);
        return "login";
    }

}

