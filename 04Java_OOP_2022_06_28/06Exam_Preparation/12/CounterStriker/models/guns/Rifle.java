package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() >= 10) {
            setBulletsCount(getBulletsCount() - 10);
            return 10;
        }

        return 0;
    }

}