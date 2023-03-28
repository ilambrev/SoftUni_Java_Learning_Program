package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BillingDetail {

    @Id
    @Column(nullable = false, unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    protected BillingDetail() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}