package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        } else {
            this.money -= product.getCost();
            this.products.add(product);
        }
    }

    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(this.name).append(" - ");

        String products = this.products.stream().map(Product::getName).collect(Collectors.joining(", "));

        if (products.isEmpty()) {
            statistics.append("Nothing bought");
        }

        statistics.append(products);

        return statistics.toString();
    }

}