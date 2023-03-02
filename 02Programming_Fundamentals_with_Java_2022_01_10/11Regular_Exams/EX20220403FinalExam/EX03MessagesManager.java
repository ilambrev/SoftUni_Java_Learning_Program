package EX20220403FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03MessagesManager {
    static class User {
        String name;
        int sentMessages;
        int receivedMessages;

        public User(String name, int sentMessages, int receivedMessages) {
            this.name = name;
            this.sentMessages = sentMessages;
            this.receivedMessages = receivedMessages;
        }

        public String getName() {
            return this.name;
        }

        public int getSentMessages() {
            return this.sentMessages;
        }

        public int getReceivedMessages() {
            return this.receivedMessages;
        }

        public void setSentMessages(int sentMessages) {
            this.sentMessages = sentMessages;
        }

        public void setReceivedMessages(int receivedMessages) {
            this.receivedMessages = receivedMessages;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalNumberOfMessages = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        Map<String, User> users = new LinkedHashMap<>();

        while (!command.equals("Statistics")) {
            String[] commandParts = command.split("=");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Add":
                    addUser(users, commandParts[1], Integer.parseInt(commandParts[2]), Integer.parseInt(commandParts[3]));
                    break;
                case "Message":
                    processMessage(users, commandParts[1], commandParts[2], totalNumberOfMessages);
                    break;
                case "Empty":
                    deleteRecord(users, commandParts[1]);
                    break;
            }

            command = scanner.nextLine();
        }
        if (users.isEmpty()) {
            System.out.println("Users count: 0");
        } else {
            System.out.println("Users count: " + users.size());
            for (Map.Entry<String, User> entry : users.entrySet()) {
                System.out.println(entry.getKey() + " - " + (entry.getValue().getSentMessages() + entry.getValue().getReceivedMessages()));
            }
        }

    }

    private static void addUser(Map<String, User> users, String userName, int sentMessages, int receivedMessages) {
        boolean userExists = users.containsKey(userName);
        if (!userExists) {
            User user = new User(userName, sentMessages, receivedMessages);
            users.put(userName, user);
        }
    }

    private static void processMessage(Map<String, User> users, String sender, String receiver, int totalNumberOfMessages) {
        if (users.containsKey(sender) && users.containsKey(receiver)) {
            int oldNumberOfSentMessages = users.get(sender).getSentMessages();
            int oldNumberOfReceivedMessages = users.get(receiver).getReceivedMessages();
            users.get(sender).setSentMessages(oldNumberOfSentMessages + 1);
            users.get(receiver).setReceivedMessages(oldNumberOfReceivedMessages + 1);
            int senderTotalMessages = users.get(sender).getSentMessages() + users.get(sender).getReceivedMessages();
            int receiverTotalMessages = users.get(receiver).getSentMessages() + users.get(receiver).getReceivedMessages();
            if (senderTotalMessages >= totalNumberOfMessages) {
                System.out.println(sender + " reached the capacity!");
                users.remove(sender);
            }
            if (receiverTotalMessages >= totalNumberOfMessages) {
                System.out.println(receiver + " reached the capacity!");
                users.remove(receiver);
            }
        }
    }

    private static void deleteRecord(Map<String, User> users, String username) {
        if (username.equals("All")) {
            users.clear();
        } else {
            users.remove(username);
        }
    }

}