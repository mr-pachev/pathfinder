package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.CategoriesRoute;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Categories extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CategoriesRoute name;

    @ManyToMany
    @JoinTable(name = "routes_categories",
            joinColumns = @JoinColumn(name = "categories_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "route_id",referencedColumnName = "id")
    )
    private Set<Route> route;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoriesRoute getName() {
        return name;
    }

    public void setName(CategoriesRoute name) {
        this.name = name;
    }

    public Set<Route> getRoute() {
        return route;
    }

    public void setRoute(Set<Route> route) {
        this.route = route;
    }

}
