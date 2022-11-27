package viceCity.models.guns;

public abstract class BaseGun implements Gun {

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    private int bulletsShot;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        this.canFire = true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or whitespace!");
        } else {
            this.name = name;
        }
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException("Bullets cannot be below zero!");
        } else {
            this.bulletsPerBarrel = bulletsPerBarrel;
        }
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException("Total bullets cannot be below zero!");
        } else {
            this.totalBullets = totalBullets;
        }
    }

    protected int getBulletsShot() {
        return this.bulletsShot;
    }

    protected void setBulletsShot(int bulletsShot) {
        this.bulletsShot = bulletsShot;
    }

    @Override
    public boolean canFire() {
        return this.canFire;
    }

    @Override
    public int fire() {
        if (!canFire()) {
            return 0;
        }

        this.bulletsShot++;

        this.canFire = bulletsShot < this.totalBullets;

        return 1;
    }

}