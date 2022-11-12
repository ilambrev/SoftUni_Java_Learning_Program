package fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        for (Instrument instrument : helper.getInstruments()) {
            while (helper.canWork()) {
                if (instrument.isBroken()) {
                    break;
                }

                helper.work();
                instrument.use();
                present.getCrafted();

                if (present.isDone()) {
                    break;
                }

            }

            if (present.isDone()) {
                break;
            }

        }

    }

}