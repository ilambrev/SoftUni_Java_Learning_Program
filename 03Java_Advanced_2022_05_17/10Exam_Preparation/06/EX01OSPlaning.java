package EX06Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX01OSPlaning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputTasks = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputThreads = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int taskToKill = Integer.parseInt(scanner.nextLine());

        Deque<Integer> tasks = new ArrayDeque<>();
        Deque<Integer> threads = new ArrayDeque<>();

        for (Integer value : inputTasks) {
            tasks.push(value);
        }

        for (Integer value : inputThreads) {
            threads.offer(value);
        }

        int thread = 0;

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentThread = threads.peek();
            int currentTask = tasks.pop();
            if (currentTask == taskToKill) {
                thread = currentThread;
                break;
            }

            if (currentThread < currentTask) {
                tasks.push(currentTask);
            }

            threads.poll();
        }

        System.out.printf("Thread with value %d killed task %d%n", thread, taskToKill);

        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}