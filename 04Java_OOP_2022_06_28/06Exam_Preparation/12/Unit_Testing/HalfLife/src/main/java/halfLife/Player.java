package halfLife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private List<Gun> guns;
    private String username;
    private int health;

    public Player(String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.guns = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().length() < 1) {
            throw new NullPointerException("Cannot be null!");
        }
        this.username = username;
    }

    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be bellow zero!");
        }
        this.health = health;
    }

    public List<Gun> getGuns() {
        return Collections.unmodifiableList(this.guns);
    }

    public void takeDamage(int damage) {
        if (this.health <= 0) {
            throw new IllegalStateException("Player is dead!");
        }

        if (this.health - damage < 0) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }

    public void addGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException("Gun cannot be null!");
        }

        this.guns.add(gun);
    }

    public boolean removeGun(Gun gun) {
        return this.guns.remove(gun);
    }

    public Gun getGun(String name) {
        Gun gun = this.guns.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
        return gun;
    }
}
