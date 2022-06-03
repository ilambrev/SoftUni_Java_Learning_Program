package E03SetsAndMapsAdvanced;

import java.util.*;

public class E13DragonArmy {

    static class Dragon {
        String name;
        int damage;
        int health;
        int armor;

        public Dragon() {

        }

        public Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return this.name;
        }

        public int getDamage() {
            return this.damage;
        }

        public int getHealth() {
            return this.health;
        }

        public int getArmor() {
            return this.armor;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Dragon>> dragonsTypes = new LinkedHashMap<>();

        int numberOfDragons = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfDragons; i++) {
            String[] dragonData = scanner.nextLine().split("\\s+");
            String type = dragonData[0];
            String name = dragonData[1];
            int damage = dragonData[2].equals("null") ? 45 : Integer.parseInt(dragonData[2]);
            int health = dragonData[3].equals("null") ? 250 : Integer.parseInt(dragonData[3]);
            int armor = dragonData[4].equals("null") ? 10 : Integer.parseInt(dragonData[4]);
            Map<String, Dragon> dragonType = new TreeMap<>();
            dragonsTypes.putIfAbsent(type, dragonType);
            dragonsTypes.get(type).putIfAbsent(name, new Dragon());
            Dragon dragon = new Dragon(name, damage, health, armor);
            dragonsTypes.get(type).put(name, dragon);
        }

        for (var type : dragonsTypes.entrySet()) {
            double averageDamage = 0.0;
            double averageHealth = 0.0;
            double averageArmor = 0.0;
            int numberOfDragonsOfTheType = type.getValue().size();
            for (var dragon : type.getValue().entrySet()) {
                averageDamage += dragon.getValue().getDamage();
                averageHealth += dragon.getValue().getHealth();
                averageArmor += dragon.getValue().getArmor();
            }
            averageDamage /= numberOfDragonsOfTheType;
            averageHealth /= numberOfDragonsOfTheType;
            averageArmor /= numberOfDragonsOfTheType;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), averageDamage, averageHealth, averageArmor);
            for (var dragon : type.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getValue().getName(),
                        dragon.getValue().getDamage(), dragon.getValue().getHealth(), dragon.getValue().getArmor());
            }
        }

    }
}