package ME05Lists;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class ME01Messaging {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split(" +");
        String[] inputText = scanner.nextLine().split("");

        List<Integer> numbersList = new ArrayList<>();
        List<String> textList = new ArrayList<>();
        List<String> message = new ArrayList<>();

        inputNumbersToList(numbersList, inputNumbers);
        inputTextToList(textList, inputText);

        for (int i = 0; i < numbersList.size(); i++) {
            int index = sumOfNumberDigits(numbersList.get(i));
            if (index > textList.size() - 1) {
                index = index % (textList.size());
            }
            message.add(textList.get(index));
            textList.remove(index);
        }

        printList(message);
    }

    private static void inputNumbersToList(List<Integer> numbersList, String[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            numbersList.add(i, Integer.parseInt(inputNumbers[i]));
        }
    }

    private static void inputTextToList(List<String> textList, String[] inputText) {
        for (int i = 0; i < inputText.length; i++) {
            textList.add(i, inputText[i]);
        }
    }

    private static int sumOfNumberDigits(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            sumOfDigits += currentDigit;
            number /= 10;
        }
        return sumOfDigits;
    }

    private static void printList(List<String> message) {
        for (int i = 0; i < message.size(); i++) {
            System.out.print(message.get(i));
        }
    }

}