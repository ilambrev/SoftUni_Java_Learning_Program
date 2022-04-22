package ME05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03TakeSkipRope {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split("");

        List<String> charactersList = new ArrayList<>();
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i].charAt(0) >= '0' && inputString[i].charAt(0) <= '9') {
                numbersList.add(Integer.parseInt(inputString[i]));
            } else {
                charactersList.add(inputString[i]);
            }
        }

        List<String> message = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                int maxIndex = index + numbersList.get(i);
                if (index + numbersList.get(i) > charactersList.size() - 1) {
                    maxIndex = charactersList.size();
                }
                for (int j = index; j < maxIndex; j++) {
                    message.add(charactersList.get(j));
                }
                index += numbersList.get(i);
            } else {
                index += numbersList.get(i);
            }
        }

        printMessageList(message);
    }

    private static void printMessageList(List<String> message) {
        for (int i = 0; i < message.size(); i++) {
            System.out.print(message.get(i));
        }
        System.out.println();
    }

}