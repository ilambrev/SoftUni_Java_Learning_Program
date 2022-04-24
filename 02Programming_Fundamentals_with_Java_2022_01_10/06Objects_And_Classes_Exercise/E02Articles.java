package E06ObjectsAndClasses;

import java.util.Scanner;

public class E02Articles {

    static class Article {
        String title;
        String content;
        String author;

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }

        void setTitle(String title) {
            this.title = title;
        }

        void setContent(String content) {
            this.content = content;
        }

        void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArticle = scanner.nextLine().split(",\\s");
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Article article = new Article(inputArticle[0], inputArticle[1], inputArticle[2]);

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(":\\s");
            switch (command[0]) {
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTitle(command[1]);
                    break;
            }
        }

        System.out.println(article);
    }
}