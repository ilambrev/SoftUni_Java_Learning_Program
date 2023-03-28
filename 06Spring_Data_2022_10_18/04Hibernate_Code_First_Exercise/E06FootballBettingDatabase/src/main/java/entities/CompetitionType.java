package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competition_types")
public class CompetitionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false)
    private String name;

    @OneToMany(targetEntity = Competition.class, mappedBy = "type")
    private Set<Competition> competitions;

    public CompetitionType() {
        super();
    }

}