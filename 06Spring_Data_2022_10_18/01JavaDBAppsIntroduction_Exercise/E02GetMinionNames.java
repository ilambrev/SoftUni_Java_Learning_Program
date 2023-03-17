import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class E02GetMinionNames {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String GET_VILLAIN_ID_QUERY = "SELECT `name` FROM `villains` WHERE `id` = ?";

    private static final String LIST_OF_MINIONS_BY_VILLAIN_QUERY = "SELECT DISTINCT(mv.`minion_id`), m.`name`, m.`age`" +
            " FROM `minions` AS m" +
            " INNER JOIN `minions_villains` AS mv" +
            " ON m.`id` = mv.`minion_id`" +
            " WHERE mv.`villain_id` = ?";

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

        Connection connection = DriverManager.getConnection(DB_CONNECTION_PATH, properties);

        PreparedStatement villainIDStatement = connection.prepareStatement(GET_VILLAIN_ID_QUERY);

        System.out.print("Enter villain id: ");
        int villainID = Integer.parseInt(scanner.nextLine());

        System.out.println();

        villainIDStatement.setInt(1, villainID);

        ResultSet villainName = villainIDStatement.executeQuery();

        if (villainName.next()) {
            System.out.println("Villain: " + villainName.getString("name"));

            PreparedStatement minionsNamesList = connection.prepareStatement(LIST_OF_MINIONS_BY_VILLAIN_QUERY);

            minionsNamesList.setInt(1, villainID);

            ResultSet minionsNames = minionsNamesList.executeQuery();

            int counter = 1;

            while (minionsNames.next()) {
                System.out.println(counter + ". " + minionsNames.getString("name") + " " + minionsNames.getString("age"));
                counter++;
            }

        } else {
            System.out.printf("No villain with ID %s exists in the database.%n", villainID);
        }

        connection.close();
    }
}