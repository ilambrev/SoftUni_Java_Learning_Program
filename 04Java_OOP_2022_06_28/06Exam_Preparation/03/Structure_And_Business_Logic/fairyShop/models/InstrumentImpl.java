package fairyShop.models;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Cannot create an Instrument with negative power!");
        } else {
            this.power = power;
        }
    }

    @Override
    public void use() {
        if (this.power - 10 < 0) {
            this.power = 0;
        } else {
            this.power -= 10;
        }
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }

}