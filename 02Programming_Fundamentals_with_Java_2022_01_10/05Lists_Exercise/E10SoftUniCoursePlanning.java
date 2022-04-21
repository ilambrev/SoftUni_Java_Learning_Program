package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E10SoftUniCoursePlanning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", +");
        String inputCommand = scanner.nextLine();

        List<String> dataList = new ArrayList<>();

        readDataListFromConsole(dataList, inputData);

        while (!inputCommand.equals("course start")) {
            String[] currentCommand = inputCommand.split(":+");

            switch (currentCommand[0]) {
                case "Add":
                    addLessonToList(dataList, currentCommand[1]);
                    break;
                case "Insert":
                    insertLessonAtIndexToList(dataList, currentCommand[1], Integer.parseInt(currentCommand[2]));
                    break;
                case "Remove":
                    removeLessonFromList(dataList, currentCommand[1]);
                    break;
                case "Swap":
                    swapLessonsInList(dataList, currentCommand[1], currentCommand[2]);
                    break;
                case "Exercise":
                    addExerciseToList(dataList, currentCommand[1]);
                    break;
            }


            inputCommand = scanner.nextLine();
        }

        printList(dataList);
    }

    private static void readDataListFromConsole(List<String> stringsList, String[] inputData) {
        for (String element : inputData) {
            stringsList.add(element);
        }
    }

    private static void addLessonToList(List<String> stringsList, String lesson) {
        boolean isLessonInList = false;
        for (String element : stringsList) {
            if (element.equals(lesson)) {
                isLessonInList = true;
                break;
            }
        }
        if (!isLessonInList) {
            stringsList.add(lesson);
        }
    }

    private static void insertLessonAtIndexToList(List<String> stringsList, String lesson, int index) {
        if (index >= 0 && index <= stringsList.size() - 1) {
            boolean isLessonInList = false;
            for (String element : stringsList) {
                if (element.equals(lesson)) {
                    isLessonInList = true;
                    break;
                }
            }
            if (!isLessonInList) {
                if (index == 0) {
                    stringsList.add(index, lesson);
                } else if (stringsList.get(index).equals(stringsList.get(index - 1) + "-Exercise")) {
                    stringsList.add(index - 1, lesson);
                } else {
                    stringsList.add(index, lesson);
                }
            }
        }
    }

    private static void removeLessonFromList(List<String> stringsList, String lesson) {
        boolean isLessonInList = false;
        int index = 0;
        for (int i = 0; i < stringsList.size(); i++) {
            if (stringsList.get(i).equals(lesson)) {
                isLessonInList = true;
                index = i;
                break;
            }
        }
        if (isLessonInList) {
            String exerciseTitle = lesson + "-Exercise";
            if ((index < stringsList.size() - 1) && stringsList.get(index + 1).equals(exerciseTitle)) {
                stringsList.remove(index + 1);
            }
            stringsList.remove(index);
        }
    }

    private static void swapLessonsInList(List<String> stringsList, String lesson1, String lesson2) {
        if (!lesson1.equals(lesson2)) {
            boolean isLesson1InList = false;
            boolean isLesson2InList = false;
            int indexLesson1 = 0;
            int indexLesson2 = 0;
            for (int i = 0; i < stringsList.size(); i++) {
                if (stringsList.get(i).equals(lesson1)) {
                    isLesson1InList = true;
                    indexLesson1 = i;
                } else if (stringsList.get(i).equals(lesson2)) {
                    isLesson2InList = true;
                    indexLesson2 = i;
                }
                if (isLesson1InList && isLesson2InList) {
                    break;
                }
            }
            if (isLesson1InList && isLesson2InList) {
                String exercise1Title = lesson1 + "-Exercise";
                String exercise2Title = lesson2 + "-Exercise";
                String exerciseToChange = "";

                String lessonToChange = stringsList.get(indexLesson1);
                stringsList.set(indexLesson1, stringsList.get(indexLesson2));
                stringsList.set(indexLesson2, lessonToChange);

                if (indexLesson1 < indexLesson2) {
                    if (indexLesson2 == (stringsList.size() - 1) && stringsList.get(indexLesson1 + 1).equals(exercise1Title)) {
                        stringsList.add(stringsList.get(indexLesson1 + 1));
                        stringsList.remove(indexLesson1 + 1);
                    } else if (indexLesson2 < (stringsList.size() - 1) && stringsList.get(indexLesson1 + 1).equals(exercise1Title) && stringsList.get(indexLesson2 + 1).equals(exercise2Title)) {
                        exerciseToChange = stringsList.get(indexLesson1 + 1);
                        stringsList.set(indexLesson1 + 1, stringsList.get(indexLesson2 + 1));
                        stringsList.set(indexLesson2 + 1, exerciseToChange);
                    } else if (indexLesson2 < (stringsList.size() - 1) && stringsList.get(indexLesson1 + 1).equals(exercise1Title)) {
                        stringsList.add(indexLesson2 + 1, stringsList.get(indexLesson1 + 1));
                        stringsList.remove(indexLesson1 + 1);
                    } else if (indexLesson2 < (stringsList.size() - 1) && stringsList.get(indexLesson2 + 1).equals(exercise2Title)) {
                        exerciseToChange = stringsList.get(indexLesson2 + 1);
                        stringsList.remove(indexLesson2 + 1);
                        stringsList.add(indexLesson1 + 1, exerciseToChange);
                    }
                } else if (indexLesson1 > indexLesson2) {
                    if (indexLesson1 == (stringsList.size() - 1) && stringsList.get(indexLesson2 + 1).equals(exercise2Title)) {
                        stringsList.add(stringsList.get(indexLesson2 + 1));
                        stringsList.remove(indexLesson2 + 1);
                    } else if (indexLesson1 < (stringsList.size() - 1) && stringsList.get(indexLesson1 + 1).equals(exercise1Title) && stringsList.get(indexLesson2 + 1).equals(exercise2Title)) {
                        exerciseToChange = stringsList.get(indexLesson1 + 1);
                        stringsList.set(indexLesson1 + 1, stringsList.get(indexLesson2 + 1));
                        stringsList.set(indexLesson2 + 1, exerciseToChange);
                    } else if (indexLesson1 < (stringsList.size() - 1) && stringsList.get(indexLesson2 + 1).equals(exercise1Title)) {
                        stringsList.add(indexLesson1 + 1, stringsList.get(indexLesson2 + 1));
                        stringsList.remove(indexLesson2 + 1);
                    } else if (indexLesson1 < (stringsList.size() - 1) && stringsList.get(indexLesson1 + 1).equals(exercise2Title)) {
                        exerciseToChange = stringsList.get(indexLesson1 + 1);
                        stringsList.remove(indexLesson1 + 1);
                        stringsList.add(indexLesson2 + 1, exerciseToChange);
                    }
                }
            }
        }
    }

    private static void addExerciseToList(List<String> stringsList, String lesson) {
        boolean isLessonInList = false;
        int index = 0;
        String exerciseTitle = lesson + "-Exercise";
        for (int i = 0; i < stringsList.size(); i++) {
            if (stringsList.get(i).equals(lesson)) {
                isLessonInList = true;
                index = i;
                break;
            }
        }
        if (isLessonInList) {
            if (index < (stringsList.size() - 1) && !stringsList.get(index + 1).equals(exerciseTitle)) {
                stringsList.add(index + 1, exerciseTitle);
            } else if (index == (stringsList.size() - 1)) {
                stringsList.add(exerciseTitle);
            }
        } else {
            stringsList.add(lesson);
            stringsList.add(exerciseTitle);
        }
    }

    private static void printList(List<String> stringsList) {
        for (int i = 0; i < stringsList.size(); i++) {
            System.out.println((i + 1) + "." + stringsList.get(i));
        }
    }

}