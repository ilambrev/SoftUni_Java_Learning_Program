package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }

        double componentsAverageOverallPerformance = this.components.stream()
                .mapToDouble(Component::getOverallPerformance).average().getAsDouble();

        return super.getOverallPerformance() + componentsAverageOverallPerformance;
    }

    @Override
    public double getPrice() {
        double componentsPrice = this.components.stream().mapToDouble(Component::getPrice).sum();
        double peripheralsPrice = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

        return super.getPrice() + componentsPrice + peripheralsPrice;
    }

    @Override
    public void addComponent(Component component) {
        Component existingComponent = this.components.stream().
                filter(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName())).findFirst().orElse(null);

        if (existingComponent != null) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = this.components.stream().
                filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);

        if (component == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }

        this.components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        Peripheral existingPeripheral = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())).findFirst().orElse(null);

        if (existingPeripheral != null) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.remove(peripheral);

        return peripheral;
    }

    @Override
    public String toString() {
        StringBuilder computerInfo = new StringBuilder();

        computerInfo.append(String.format(PRODUCT_TO_STRING,
                getOverallPerformance(), getPrice(), this.getClass().getSimpleName(), getManufacturer(), getModel(),getId()))
                .append(System.lineSeparator());

        computerInfo.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size())).append(System.lineSeparator());

        this.components.forEach(c -> computerInfo.append("  ").append(c.toString()).append(System.lineSeparator()));

        double peripheralsAverageOverallPerformance = this.peripherals.stream()
                .mapToDouble(Peripheral::getOverallPerformance).average().orElse(0.0);

        computerInfo.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), peripheralsAverageOverallPerformance))
                .append(System.lineSeparator());

        this.peripherals.forEach(p -> computerInfo.append("  ").append(p.toString()).append(System.lineSeparator()));

        return computerInfo.toString().trim();
    }

}