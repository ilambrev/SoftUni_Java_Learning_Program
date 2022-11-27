package viceCity.models.guns;

public class Rifle extends BaseGun {

    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        if (!canFire()) {
            if (getTotalBullets() >= 5) {
                setTotalBullets(getTotalBullets() - getBulletsPerBarrel());
            } else {
                return 0;
            }
        }

        setBulletsShot(getBulletsShot() + 5);

        return 5;
    }

}