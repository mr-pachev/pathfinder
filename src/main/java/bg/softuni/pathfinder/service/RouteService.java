package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entity.Route;
import jakarta.transaction.Transactional;

import java.util.List;
@Transactional
public interface RouteService {
    List<Route> viewAllRoutes();
}
