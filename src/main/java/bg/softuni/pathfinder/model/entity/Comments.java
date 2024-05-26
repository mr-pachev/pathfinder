package bg.softuni.pathfinder.model.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {
    private boolean approved;
    private LocalDateTime created;
    @Column(name = "text_content")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
}
