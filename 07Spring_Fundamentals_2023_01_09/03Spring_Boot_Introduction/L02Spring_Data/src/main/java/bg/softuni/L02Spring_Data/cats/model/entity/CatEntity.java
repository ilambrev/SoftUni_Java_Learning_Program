package bg.softuni.L02Spring_Data.cats.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class CatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_name", nullable = false)
    private String catName;

    @ManyToOne(targetEntity = OwnerEntity.class, optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private OwnerEntity owner;

    public CatEntity() {
    }

    public Long getId() {
        return id;
    }

    public CatEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCatName() {
        return catName;
    }

    public CatEntity setCatName(String catName) {
        this.catName = catName;
        return this;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public CatEntity setOwner(OwnerEntity owner) {
        this.owner = owner;
        return this;
    }

}