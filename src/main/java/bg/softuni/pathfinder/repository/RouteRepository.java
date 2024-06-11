package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
