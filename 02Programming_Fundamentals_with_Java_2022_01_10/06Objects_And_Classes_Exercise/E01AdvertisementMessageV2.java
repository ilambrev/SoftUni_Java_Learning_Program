package E06ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessageV2 {

    static class Message {
        String phrase;
        String event;
        String author;
        String city;

        String generateMessage() {
            return String.format("%s %s %s – %s", this.phrase, this.event, this.author, this.city);
        }

        void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        void setEvent(String event) {
            this.event = event;
        }

        void setAuthor(String author) {
            this.author = author;
        }

        void setCity(String city) {
            this.city = city;
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
            Message message = new Message();

            for (int j = 0; j < 4; j++) {
                int index = rdm.nextInt(arrLengths[j]);
                if (j == 0) {
                    message.setPhrase(phrases[index]);
                } else if (j == 1) {
                    message.setEvent(events[index]);
                } else if (j == 2) {
                    message.setAuthor(authors[index]);
                } else {
                    message.setCity(cities[index]);
                }
            }

            System.out.println(message.generateMessage());
        }

    }
}