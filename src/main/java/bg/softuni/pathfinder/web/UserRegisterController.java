package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegisterController {

    @GetMapping("/users/register")
    public String viewUserRegister(){
//        if (!model.containsAttribute("userRegistrationDTO")) {
//            model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
//        }


        return "register";
    }
}
