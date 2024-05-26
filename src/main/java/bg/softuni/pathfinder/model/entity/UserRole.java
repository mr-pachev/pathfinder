package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.Role;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name="roles")
public class UserRole extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(targetEntity = User.class, mappedBy = "userRole")
    Set<User> users;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
