package EX02FinalExam;

import java.util.*;

public class EX03PlantDiscovery {

    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public Plant(String name, int rarity, List<Double> rating) {
            this.name = name;
            this.rarity = rarity;
            this.rating = rating;
        }


        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return this.rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getRating() {
            return this.rating;
        }

        public void setRating(List<Double> rating) {
            this.rating = rating;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        Map<String, Plant> plants = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPlants; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            List<Double> rating = new ArrayList<>();
            Plant plant = new Plant(plantInfo[0], Integer.parseInt(plantInfo[1]), rating);
            plants.put(plantInfo[0], plant);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] commandParams = input.split("(: )|( - )");
            String command = commandParams[0];
            if (plants.containsKey(commandParams[1])) {
                switch (command) {
                    case "Rate":
                        ratePlant(plants, commandParams[1], Double.parseDouble(commandParams[2]));
                        break;
                    case "Update":
                        updatePlantRarity(plants, commandParams[1], Integer.parseInt(commandParams[2]));
                        break;
                    case "Reset":
                        resetPlantRatings(plants, commandParams[1]);
                        break;
                }
            } else {
                System.out.println("error");
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Plant> entry : plants.entrySet()) {
            double averageRating = 0.00;
            if (!entry.getValue().getRating().isEmpty()) {
                for (int i = 0; i < entry.getValue().getRating().size(); i++) {
                    averageRating += entry.getValue().getRating().get(i);
                }
                averageRating /= entry.getValue().getRating().size();
            }

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue().getRarity(), averageRating);
        }
    }

    private static void ratePlant(Map<String, Plant> plants, String plantName, double rating) {
        plants.get(plantName).getRating().add(rating);
    }

    private static void updatePlantRarity(Map<String, Plant> plants, String plantName, int rarity) {
        plants.get(plantName).setRarity(rarity);
    }

    private static void resetPlantRatings(Map<String, Plant> plants, String plantName) {
        plants.get(plantName).getRating().clear();
    }

}