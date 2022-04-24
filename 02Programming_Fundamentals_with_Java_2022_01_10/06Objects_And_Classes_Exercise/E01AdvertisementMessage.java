package E06ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessage {

    static class Message {
        String phrase;
        String event;
        String author;
        String city;

        Message(String phrase, String event, String author, String city) {
            this.phrase = phrase;
            this.event = event;
            this.author = author;
            this.city = city;
        }

        String generateMessage() {
            return String.format("%s %s %s – %s", this.phrase, this.event, this.author, this.city);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int advertisementNumber = Integer.parseInt(scanner.nextLine());

        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int[] arrLengths = new int[]{phrases.length, events.length, authors.length, cities.length};

        Random rdm = new Random();

        for (int i = 1; i <= advertisementNumber; i++) {
            String phrase = "";
            String event = "";
            String author = "";
            String city = "";

            for (int j = 0; j < 4; j++) {
                int index = rdm.nextInt(arrLengths[j]);
                if (j == 0) {
                    phrase = phrases[index];
                } else if (j == 1) {
                    event = events[index];
                } else if (j == 2) {
                    author = authors[index];
                } else {
                    city = cities[index];
                }
            }

            Message message = new Message(phrase, event, author, city);
            System.out.println(message.generateMessage());
        }

    }
}