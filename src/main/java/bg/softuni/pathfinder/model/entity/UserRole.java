package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.Role;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name="roles")
public class UserRole extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Role name;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "roles_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id")
    )
    Set<User> users;

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
