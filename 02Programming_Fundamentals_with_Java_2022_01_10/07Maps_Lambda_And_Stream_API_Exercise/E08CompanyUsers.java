package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E08CompanyUsers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, String>> companies = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] company = input.split(" -> ");
            Map<String, String> employees = new LinkedHashMap<>();
            if (companies.containsKey(company[0])) {
                employees = companies.get(company[0]);
                if (!employees.containsKey(company[1])) {
                    employees.put(company[1], company[0]);
                }
            } else {
                employees.put(company[1], company[0]);
            }
            companies.put(company[0], employees);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, String>> entry : companies.entrySet()) {
            Map<String, String> employees = entry.getValue();
            System.out.println(entry.getKey());
            for (Map.Entry<String, String> employee : employees.entrySet()) {
                System.out.println("-- " + employee.getKey());
            }
        }

    }
}