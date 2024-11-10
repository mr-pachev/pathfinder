package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    //view all routes
    @GetMapping("/routes")
    public String allRoutedView(Model model){
        List<Route> allRoutes = routeService.viewAllRoutes();
        model.addAttribute("routes", allRoutes);

        return "routes";
    }

    //add route
    @GetMapping("/add-route")
    public String viewAddRoute(Model model) {

        if (!model.containsAttribute("addRouteDTO")) {
            model.addAttribute("addRouteDTO", new addRouteDTO());
        }

        model.addAttribute("engineType", Engine.values());
        model.addAttribute("transmissionType", Transmission.values());
        model.addAttribute("brands", brandService.allBrands());
        model.addAttribute("models", modelService.allModel());

        if (!model.containsAttribute("isNoMatchModel")) {
            model.addAttribute("isNoMatchModel", false);
        }

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String creatOffer(@Valid AddOfferDTO addOfferDTO,
                             BindingResult bindingResult,
                             RedirectAttributes rAtt) {

        boolean isNoMatchModel = false;

        if (!addOfferDTO.getBrand().isEmpty()) {
            isNoMatchModel = !brandService.modelsByBrand(addOfferDTO.getBrand())
                    .contains(addOfferDTO.getModel());
        }

        if (bindingResult.hasErrors() || isNoMatchModel) {
            rAtt.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            rAtt.addFlashAttribute("engineType", Engine.values());
            rAtt.addFlashAttribute("transmissionType", Transmission.values());
            rAtt.addFlashAttribute("brands", brandService.allBrands());
            rAtt.addFlashAttribute("models", modelService.allModel());

            if (isNoMatchModel) {
                rAtt.addFlashAttribute("isNoMatchModel", true);
            }

            return "redirect:/offers/add";
        }

        long userId = userHelperService.getUser().getId();
        long offerId = offerService.addOffer(addOfferDTO, userId);

        return "redirect:/details/" + offerId;
    }


    @GetMapping("/details/{id}")
    public String viewOfferDetail(@PathVariable("id") long id, Model model) {
        OfferDTO offerDTO = offerService.getOfferDTOById(id);

        model.addAttribute("offerDTO", offerDTO);

        return "details";
    }
}
