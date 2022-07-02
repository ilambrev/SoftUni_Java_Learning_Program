package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] initialSignals = scanner.nextLine().split("\\s+");

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String signal : initialSignals) {
            TrafficLight trafficLight = new TrafficLight(Signal.valueOf(signal));
            trafficLights.add(trafficLight);
        }

        int numberOfLightChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfLightChanges; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeSignal();
                System.out.printf("%s ", trafficLight.getSignal().name());
            }
            System.out.println();
        }

    }
}