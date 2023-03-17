import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class E04ChangeTownNamesCasing {

    private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost:3306/minions_db";

    private static final String CHANGE_TOWNS_NAMES_TO_UPPERCASE = "UPDATE `towns`" +
            " SET `name` = upper(`name`)" +
            " WHERE `country` LIKE ?";

    private static final String LIST_OF_TOWNS_WITH_CHANGED_NAMES = "SELECT `name` FROM `towns` WHERE `country` LIKE ?";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.println();

        System.out.print("Enter password default (empty): ");
        String password = scanner.nextLine();

        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(DB_CONNECTION_STRING, properties);

        String countryName = scanner.nextLine();

        System.out.println();

        PreparedStatement townStatement = connection.prepareStatement(CHANGE_TOWNS_NAMES_TO_UPPERCASE);
        townStatement.setString(1, countryName);
        int numberOfTowns = townStatement.executeUpdate();

        if (numberOfTowns > 0) {
            PreparedStatement listOfTownsStatement = connection.prepareStatement(LIST_OF_TOWNS_WITH_CHANGED_NAMES);
            listOfTownsStatement.setString(1, countryName);
            ResultSet listOfTowns = listOfTownsStatement.executeQuery();

            List<String> townsNames = new ArrayList<>();

            while (listOfTowns.next()) {
                townsNames.add(listOfTowns.getString("name"));
            }

            System.out.println(numberOfTowns + " town names were affected.");
            System.out.println("[" + String.join(", ", townsNames) + "]");
        } else {
            System.out.println("No town names were affected.");
        }

        connection.close();

    }
}