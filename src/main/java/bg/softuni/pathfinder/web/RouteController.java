package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {
    RouteService routeService;

    @GetMapping("/routes")
    public String carRoutesView(Model model){
        List<Route> allRoutes = routeService.viewAllRoutes();
        model.addAttribute("routes", allRoutes);

        return "routes";
    }
}
