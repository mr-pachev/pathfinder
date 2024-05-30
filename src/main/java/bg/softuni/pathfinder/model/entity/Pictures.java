package bg.softuni.pathfinder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Pictures extends BaseEntity{
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String url;

    @ManyToOne

    private User author;

    private Route route;
}
