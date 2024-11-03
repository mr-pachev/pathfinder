package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.RegisterDTO;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    //add new user
    @GetMapping("/users/register")
    public String showRegistrationForm(Model model) {

        if (!model.containsAttribute("registerDTO")) {
            model.addAttribute("registerDTO", new RegisterDTO());
        }

        return "register";
    }

    @PostMapping("/users/register")
    public String registerUser(@Valid RegisterDTO registerDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        registerDTO.setUserIsExist(userService.isExistUser(registerDTO.getUsername()));

        registerDTO.setEmailIsExist(userService.isExistEmail(registerDTO.getEmail()));

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            registerDTO.setUnConfPass(true);
        }

        if (bindingResult.hasErrors()
                || registerDTO.isUserIsExist()
                || registerDTO.isEmailIsExist()
                || registerDTO.isUnConfPass()) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/users/register";
        }
        userService.registrationUser(registerDTO);

        return "redirect:/";
    }
}
