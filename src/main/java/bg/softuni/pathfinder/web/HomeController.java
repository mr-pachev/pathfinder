package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePageView(Model model){
        double sofiaTemperature = new Random().nextDouble();

        model.addAttribute("sofiaTemp", sofiaTemperature);

        return "index";
    }
}
