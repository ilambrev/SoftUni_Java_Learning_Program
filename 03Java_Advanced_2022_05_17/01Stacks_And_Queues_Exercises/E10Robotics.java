package E01StacksAndQueues;

import java.util.*;

public class E10Robotics {

    static class Robot {
        String robotModel;
        int processTime;
        int timeToFinishInSeconds;

        public Robot(String robotModel, int processTime, int timeToFinishInSeconds) {
            this.robotModel = robotModel;
            this.processTime = processTime;
            this.timeToFinishInSeconds = timeToFinishInSeconds;
        }

        public String getRobotModel() {
            return this.robotModel;
        }

        public int getProcessTime() {
            return this.processTime;
        }

        public int getTimeToFinishInSeconds() {
            return this.timeToFinishInSeconds;
        }

        public void setTimeToFinishInSeconds(int timeToFinishInSeconds) {
            this.timeToFinishInSeconds = timeToFinishInSeconds;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Robot> robots = new ArrayDeque<>();
        Deque<String> details = new ArrayDeque<>();

        String[] robotsList = scanner.nextLine().split(";");
        int[] startTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int timeInSeconds = startTime[0] * 3600 + startTime[1] * 60 + startTime[2];

        for (int i = 0; i < robotsList.length; i++) {
            String[] robotParameters = robotsList[i].split("-");
            String robotModel = robotParameters[0];
            int processTime = Integer.parseInt(robotParameters[1]);
            Robot robot = new Robot(robotModel, processTime, timeInSeconds);
            robots.offer(robot);
        }

        String detail = scanner.nextLine();

        while (!detail.equals("End")) {
            details.offer(detail);
            detail = scanner.nextLine();
        }

        while (!details.isEmpty()) {
            timeInSeconds++;
            String currentDetail = details.poll();
            String availableRobot = checkForFreeRobot(robots, timeInSeconds);
            if (availableRobot.equals("All robots are busy")) {
                details.offer(currentDetail);
            } else {
                int meaningTime = timeInSeconds % 86400;
                int hours = meaningTime / 3600;
                int minutes = (meaningTime - hours * 3600) / 60;
                int seconds = meaningTime - hours * 3600 - minutes * 60;
                System.out.printf("%s - %s [%02d:%02d:%02d]%n", availableRobot, currentDetail, hours, minutes, seconds);
            }
        }

    }

    private static String checkForFreeRobot(Deque<Robot> robots, int timeInSeconds) {
        for (int i = 0; i < robots.size(); i++) {
            Robot robot = robots.poll();
            if (robot != null) {
                int timeToFinishInSeconds = robot.getTimeToFinishInSeconds();
                if (timeToFinishInSeconds <= timeInSeconds) {
                    timeToFinishInSeconds = timeInSeconds + robot.getProcessTime();
                    robot.setTimeToFinishInSeconds(timeToFinishInSeconds);
                    robots.offer(robot);
                    return robot.getRobotModel();
                }
            }
            robots.offer(robot);
        }

        return "All robots are busy";
    }

}