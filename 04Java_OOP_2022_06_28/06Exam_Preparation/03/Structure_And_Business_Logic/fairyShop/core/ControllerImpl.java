package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private final HelperRepository helpers;
    private final PresentRepository presents;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }


    @Override
    public String addHelper(String type, String helperName) {
        if (!"Happy".equals(type) && !"Sleepy".equals(type)) {
            throw new IllegalArgumentException("Helper type doesn't exist!");
        } else {
            Helper helper;
            if ("Happy".equals(type)) {
                helper = new Happy(helperName);
            } else {
                helper = new Sleepy(helperName);
            }

            helpers.add(helper);
        }

        return String.format("Successfully added %s named %s!", type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = findHelperByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException("The helper you want to add an instrument to doesn't exist!");
        } else {
            Instrument instrument = new InstrumentImpl(power);
            helper.addInstrument(instrument);
        }

        return String.format("Successfully added instrument with power %d to helper %s!", power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presents.add(present);

        return String.format("Successfully added Present: %s!", presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = presents.getModels().stream().filter(p -> p.getName().equals(presentName)).findFirst().orElse(null);

        List<Helper> helpersWithPowerAbove50 = new ArrayList<>();

        for (Helper helper : helpers.getModels()) {
            if (helper.getEnergy() > 50) {
                helpersWithPowerAbove50.add(helper);
            }
        }

        long brokenInstruments = 0;

        if (helpersWithPowerAbove50.isEmpty()) {
            throw new IllegalArgumentException("There is no helper ready to start crafting!");
        } else {
            for (Helper helper : helpersWithPowerAbove50) {
                Shop shop = new ShopImpl();
                shop.craft(present, helper);
                brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
                assert present != null;
                if (present.isDone()) {
                    return String.format("Present %s is done. %d instrument/s have been broken while working on it!", presentName, brokenInstruments);
                }
            }
        }

        return String.format("Present %s is not done. %d instrument/s have been broken while working on it!", presentName, brokenInstruments);
    }

    @Override
    public String report() {
        StringBuilder reportInfo = new StringBuilder();

        long presentsCrafted = presents.getModels().stream().filter(Present::isDone).count();

        reportInfo.append(String.format("%d presents are done!", presentsCrafted)).append(System.lineSeparator());

        reportInfo.append("Helpers info:").append(System.lineSeparator());

        for (Helper helper : helpers.getModels()) {
            reportInfo.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            reportInfo.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());

            long unbrokenInstruments = helper.getInstruments().stream().filter(i -> !i.isBroken()).count();

            reportInfo.append(String.format("Instruments: %d not broken left", unbrokenInstruments)).append(System.lineSeparator());
        }

        return reportInfo.toString().trim();
    }

    private Helper findHelperByName(String helperName) {
        return helpers.getModels().stream().filter(h -> h.getName().equals(helperName)).findFirst().orElse(null);
    }

}