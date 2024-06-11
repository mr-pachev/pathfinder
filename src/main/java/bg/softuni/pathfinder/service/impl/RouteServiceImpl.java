package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> viewAllRoutes() {

        return routeRepository.findAll();
    }
}
