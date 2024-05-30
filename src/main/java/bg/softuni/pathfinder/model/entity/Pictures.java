package bg.softuni.pathfinder.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Pictures extends BaseEntity{
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
}
