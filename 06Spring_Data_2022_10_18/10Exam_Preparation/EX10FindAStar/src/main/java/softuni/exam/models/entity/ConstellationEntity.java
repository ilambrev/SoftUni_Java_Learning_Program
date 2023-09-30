package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class ConstellationEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(targetEntity = StarEntity.class, mappedBy = "constellation")
    private Set<StarEntity> stars;

    public ConstellationEntity() {
        this.stars = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StarEntity> getStars() {
        return stars;
    }

    public void setStars(Set<StarEntity> stars) {
        this.stars = stars;
    }

}