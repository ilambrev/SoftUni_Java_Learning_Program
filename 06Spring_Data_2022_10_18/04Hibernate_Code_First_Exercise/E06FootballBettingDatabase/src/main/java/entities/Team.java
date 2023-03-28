package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    private String logo;

    @Column(length = 3, nullable = false)
    private String initials;

    @ManyToOne
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "id")
    private Color primaryKitColor;

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color", referencedColumnName = "id")
    private Color secondaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    private BigDecimal budget;

    @OneToMany(targetEntity = Player.class, mappedBy = "team")
    private Set<Player> players;

    public Team () {
        super();
    }

}