package easterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;


    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        int indexOfEgg = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)) {
                indexOfEgg = i;
                break;
            }
        }
        if (indexOfEgg > -1) {
            data.remove(indexOfEgg);
            return true;
        } else {
            return false;
        }
    }

    public Egg getStrongestEgg() {
        Egg egg = null;
        int maxStrength = Integer.MIN_VALUE;
        for (Egg e : this.data) {
            if (e.getStrength() > maxStrength) {
                egg = e;
                maxStrength = e.getStrength();
            }
        }
        return egg;
    }

    public Egg getEgg(String color) {
        Egg egg = null;
        for (Egg e : this.data) {
            if (e.getColor().equals(color)) {
                egg = e;
                break;
            }
        }
        return egg;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        String printEggs = data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator()));
        return String.format("%s basket contains:%n%s", this.material, printEggs);
    }

}