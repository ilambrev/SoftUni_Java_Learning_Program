package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class E09PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int initialNumberOfPlants = Integer.parseInt(scanner.nextLine());

        int[] inputSequence = new int[initialNumberOfPlants];

        for (int i = 0; i < inputSequence.length; i++) {
            inputSequence[i] = scanner.nextInt();
        }

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondQueue = new ArrayDeque<>();

        for (int i = inputSequence.length - 1; i >= 0; i--) {
            firstQueue.offer(inputSequence[i]);
        }

        int days = 0;
        boolean isThereDyingPlant = true;

        while (isThereDyingPlant) {
            days++;
            int firstQueueSize;
            int secondQueueSize;
            if (days % 2 == 0) {
                secondQueueSize = secondQueue.size();
                while (secondQueue.size() > 1) {
                    int currentPlant = secondQueue.poll();
                    if (secondQueue.peek() != null) {
                        int leftPlant = secondQueue.peek();
                        if (currentPlant <= leftPlant) {
                            firstQueue.offer(currentPlant);
                        }
                    }
                }
                firstQueue.offer(Objects.requireNonNull(secondQueue.poll()));
                firstQueueSize = firstQueue.size();
            } else {
                firstQueueSize = firstQueue.size();
                while (firstQueue.size() > 1) {
                    int currentPlant = firstQueue.poll();
                    if (firstQueue.peek() != null) {
                        int leftPlant = firstQueue.peek();
                        if (currentPlant <= leftPlant) {
                            secondQueue.offer(currentPlant);
                        }
                    }
                }
                secondQueue.offer(Objects.requireNonNull(firstQueue.poll()));
                secondQueueSize = secondQueue.size();
            }
            if (firstQueueSize == secondQueueSize) {
                isThereDyingPlant = false;
            }
        }

        System.out.println(days - 1);
    }
}