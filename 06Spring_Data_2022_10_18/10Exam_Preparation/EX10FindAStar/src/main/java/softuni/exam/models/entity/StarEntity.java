package softuni.exam.models.entity;

import softuni.exam.models.enums.StarTypeEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stars")
public class StarEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "light_years", nullable = false)
    private Double lightYears;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_type", nullable = false)
    private StarTypeEnum starType;

    @OneToMany(targetEntity = AstronomerEntity.class, mappedBy = "observingStar")
    private Set<AstronomerEntity> observers;

    @ManyToOne(targetEntity = ConstellationEntity.class)
    @JoinColumn(name = "constellation_id", referencedColumnName = "id")
    private ConstellationEntity constellation;

    public StarEntity() {
        this.observers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarTypeEnum getStarType() {
        return starType;
    }

    public void setStarType(StarTypeEnum starType) {
        this.starType = starType;
    }

    public Set<AstronomerEntity> getObservers() {
        return observers;
    }

    public void setObservers(Set<AstronomerEntity> observers) {
        this.observers = observers;
    }

    public ConstellationEntity getConstellation() {
        return constellation;
    }

    public void setConstellation(ConstellationEntity constellation) {
        this.constellation = constellation;
    }

}