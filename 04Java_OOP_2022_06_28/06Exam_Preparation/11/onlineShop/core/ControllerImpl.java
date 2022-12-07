package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Collection<Computer> computers;
    private Collection<Component> components;
    private Collection<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        if (this.computers.stream().filter(c -> c.getId() == id).findFirst().orElse(null) != null) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        Computer computer;

        if ("DesktopComputer".equals(computerType)) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if ("Laptop".equals(computerType)) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        this.computers.add(computer);

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (this.peripherals.stream().filter(p -> p.getId() == id).findFirst().orElse(null) != null) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;

        if ("Headset".equals(peripheralType)) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if ("Keyboard".equals(peripheralType)) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if ("Monitor".equals(peripheralType)) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if ("Mouse".equals(peripheralType)) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        Computer computer = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        assert computer != null;
        computer.addPeripheral(peripheral);

        this.peripherals.add(peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        Peripheral peripheral = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        assert peripheral != null;
        computer.removePeripheral(peripheralType);
        this.peripherals.remove(peripheral);

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (this.components.stream().filter(c -> c.getId() == id).findFirst().orElse(null) != null) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;

        if ("CentralProcessingUnit".equals(componentType)) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if ("Motherboard".equals(componentType)) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if ("PowerSupply".equals(componentType)) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if ("RandomAccessMemory".equals(componentType)) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if ("SolidStateDrive".equals(componentType)) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if ("VideoCard".equals(componentType)) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        Computer computer = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        computer.addComponent(component);

        this.components.add(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        Component component = this.components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        assert component != null;
        computer.removeComponent(componentType);
        this.components.remove(component);

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = this.computers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        assert computer != null;
        String computerData = getComputerData(id);
        this.computers.remove(computer);

        return computerData;
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = this.computers.stream().filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparing(Product::getOverallPerformance)).orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        this.computers.remove(computer);

        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.computers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        return computer.toString();
    }

}