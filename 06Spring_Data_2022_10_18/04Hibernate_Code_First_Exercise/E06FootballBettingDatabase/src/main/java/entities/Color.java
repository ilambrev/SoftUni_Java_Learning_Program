package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {

    public Color() {
        super();
    }

}