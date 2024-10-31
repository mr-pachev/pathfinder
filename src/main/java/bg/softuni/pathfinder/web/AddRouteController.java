package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddRouteController {
    @GetMapping("/add-route")
    public String viewAddRoute(){

        return "add-route";
    }
}
