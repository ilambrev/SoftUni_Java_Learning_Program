package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;


    public PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setAlive();
        setGun(gun);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }

        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }

        this.health = health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }

        this.armor = armor;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    private void setAlive() {
        this.isAlive = this.health > 0;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }

        this.gun = gun;
    }

    @Override
    public void takeDamage(int points) {
        if (points > this.armor) {
            points -= this.armor;
            this.armor = 0;
            if (this.health - points <= 0) {
                this.health = 0;
                setAlive();
            } else {
                this.health -= points;
            }
        } else {
            this.armor -= points;
        }

    }

    @Override
    public String toString() {
        StringBuilder playerInfo = new StringBuilder();

        playerInfo.append(String.format("%s: %s", this.getClass().getSimpleName(), this.username)).append(System.lineSeparator());

        playerInfo.append(String.format("--Health: %d", this.health)).append(System.lineSeparator());

        playerInfo.append(String.format("--Armor: %d", this.armor)).append(System.lineSeparator());

        playerInfo.append(String.format("--Gun: %s", this.gun.getName())).append(System.lineSeparator());

        return playerInfo.toString().trim();
    }

}