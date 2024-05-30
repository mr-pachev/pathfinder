package bg.softuni.pathfinder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(name = " gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    private
}
