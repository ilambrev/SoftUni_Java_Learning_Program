package EX06FinalExamRetake2019PartII;

import java.util.*;

public class EX04SantasNewList {

    static class Child {
        String name;
        int presents;

        public Child(String name, int presents) {
            this.name = name;
            this.presents = presents;
        }

        public String getName() {
            return this.name;
        }

        public int getPresents() {
            return this.presents;
        }

        public void setPresents(int presents) {
            this.presents = presents;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        Map<String, Child> children = new TreeMap<>();
        Map<String, Integer> presents = new LinkedHashMap<>();

        while (!inputString.equals("END")) {
            String[] commandParts = inputString.split("->");
            String name = commandParts[0];
            if (name.equals("Remove")) {
                if (children.containsKey(commandParts[1])) {
                    children.remove((commandParts[1]));
                }
            } else {
                String presentType = commandParts[1];
                int presentAmount = Integer.parseInt(commandParts[2]);
                if (presentAmount > 0) {
                    if (children.containsKey(name)) {
                        int oldPresentsAmount = children.get(name).getPresents();
                        children.get(name).setPresents(oldPresentsAmount + presentAmount);
                    } else {
                        Child child = new Child(name, presentAmount);
                        children.put(name, child);
                    }
                    if (presents.containsKey(presentType)) {
                        int oldPresentTypeAmount = presents.get(presentType);
                        presents.put(presentType, oldPresentTypeAmount + presentAmount);
                    } else {
                        presents.put(presentType, presentAmount);
                    }
                }
            }
            inputString = scanner.nextLine();
        }

        List<Child> allChildren = new ArrayList<>(children.values());


        Collections.sort(allChildren, (a, b) ->
        {
            if (a.getPresents() != b.getPresents()) {
                return Integer.compare(b.getPresents(), a.getPresents());
            } else {
                return a.getName().compareTo(b.getName());
            }
        });

        System.out.println("Children:");

        for (Child child : allChildren) {
            System.out.println(child.getName() + " -> " + child.getPresents());
        }

        System.out.println("Presents:");

        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}