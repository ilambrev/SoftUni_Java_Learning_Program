package bg.softuni.L02Spring_Data.cats.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @OneToMany(targetEntity = CatEntity.class, mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CatEntity> cats;

    public OwnerEntity() {
        this.cats = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public OwnerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OwnerEntity setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public List<CatEntity> getCats() {
        return cats;
    }

    public OwnerEntity setCats(List<CatEntity> cats) {
        this.cats = cats;
        return this;
    }

    public OwnerEntity addCat(CatEntity cat) {
        this.cats.add(cat);
        return this;
    }

}
