package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.UserRole;
import bg.softuni.pathfinder.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findAllById(long id);
    UserRole findByName(Role role);
}
