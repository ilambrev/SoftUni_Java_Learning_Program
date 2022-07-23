package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder calls = new StringBuilder();
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i).matches("^\\d+$")) {
                calls.append("Calling... ").append(this.numbers.get(i));
            } else {
                calls.append("Invalid number!");
            }

            if (i < this.numbers.size() - 1) {
                calls.append(System.lineSeparator());
            }
        }

        return calls.toString();
    }

    @Override
    public String browse() {
        StringBuilder sites = new StringBuilder();
        for (int i = 0; i < this.urls.size(); i++) {
            char[] symbols = this.urls.get(i).toCharArray();

            boolean urlContainsDigit = false;

            for (int j = 0; j < symbols.length; j++) {
                if (Character.isDigit(symbols[j])) {
                    urlContainsDigit = true;
                    break;
                }
            }

            if (urlContainsDigit) {
                sites.append("Invalid URL!");
            } else {
                sites.append("Browsing: ").append(this.urls.get(i)).append("!");
            }

            if (i < this.urls.size() - 1) {
                sites.append(System.lineSeparator());
            }
        }

        return sites.toString();
    }

}