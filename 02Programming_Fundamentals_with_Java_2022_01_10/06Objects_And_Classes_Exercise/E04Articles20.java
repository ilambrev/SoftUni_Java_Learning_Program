package E06ObjectsAndClasses;

import java.util.Arrays;
import java.util.Scanner;

public class E04Articles20 {

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

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Article[] articles = new Article[numberOfInputs];

        for (int i = 0; i < articles.length; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0], input[1], input[2]);
            articles[i] = article;
        }

        String sortCriteria = scanner.nextLine();

        switch(sortCriteria) {
            case "title":
                Arrays.sort(articles, (a1, a2) -> (a1.getTitle().compareTo(a2.getTitle())));
                break;
            case "content":
                Arrays.sort(articles, (a1, a2) -> (a1.getContent().compareTo(a2.getContent())));
                break;
            case "author":
                Arrays.sort(articles, (a1, a2) -> (a1.getAuthor().compareTo(a2.getAuthor())));
                break;
        }
        for(Article article : articles) {
            System.out.println(article);
        }

    }
}