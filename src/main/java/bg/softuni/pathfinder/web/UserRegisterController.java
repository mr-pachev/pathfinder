package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {

    //add new user
    @GetMapping("/users/register")
    public String showRegistrationForm(Model model) {

        if (!model.containsAttribute("registerDTO")) {
            model.addAttribute("registerDTO", new RegisterDTO());
        }

        return "register";
    }

    @PostMapping("register")
    public String registerUser(@Valid RegisterDTO registerDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        registerDTO.setUserIsExist(userService.isExistUser(userRegistrationDTO.getUsername()));

        userRegistrationDTO.setEmailIsExist(userService.isExistEmail(userRegistrationDTO.getEmail()));

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            registerDTO.setUnConfPass(true);
        }

        if (bindingResult.hasErrors()
                || userRegistrationDTO.isUserIsExist()
                || userRegistrationDTO.isEmailIsExist()
                || userRegistrationDTO.isUnConfPass()) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/register";
        }
        userService.registrationUser(userRegistrationDTO);

        return "redirect:/";
    }
}
