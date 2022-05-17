package EX04FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02FancyBarcodes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int barcodeNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= barcodeNumber; i++) {
            String barCode = scanner.nextLine();
            Pattern pattern = Pattern.compile("^@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+$");
            Matcher matcher = pattern.matcher(barCode);
            if (matcher.find()) {
                String product = matcher.group("product");
                StringBuilder productGroup = new StringBuilder();
                for (int j = 0; j < product.length(); j++) {
                    if (product.charAt(j) >= '0' && product.charAt(j) <= '9') {
                        productGroup.append(product.charAt(j));
                    }
                }
                if (productGroup.toString().isEmpty()) {
                    productGroup.append("00");
                }
                System.out.printf("Product group: %s%n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}