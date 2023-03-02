package EX20220220MidExam;

import java.util.Scanner;

public class EX01ExperienceGaining {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int initialBattlesCount = Integer.parseInt(scanner.nextLine());

        double battleExperience = 0;
        int currentBattleCount = 0;
        boolean fullExperienceGathered = false;

        for (int i = 1; i <= initialBattlesCount; i++) {
            double currentBattleExperience = Double.parseDouble(scanner.nextLine());
            battleExperience += currentBattleExperience;
            if (i % 3 == 0) {
                battleExperience += (currentBattleExperience * 0.15);
            }
            if (i % 5 == 0) {
                battleExperience -= (currentBattleExperience * 0.10);
            }
            if (i % 15 == 0) {
                battleExperience += (currentBattleExperience * 0.05);
            }
            currentBattleCount++;
            if (battleExperience >= neededExperience) {
                fullExperienceGathered = true;
                break;
            }
        }

        if (fullExperienceGathered) {
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", currentBattleCount);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n", (neededExperience - battleExperience));
        }
    }
}