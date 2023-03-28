package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "competition_type", referencedColumnName = "id")
    private CompetitionType type;

    public Competition() {
        super();
    }
}