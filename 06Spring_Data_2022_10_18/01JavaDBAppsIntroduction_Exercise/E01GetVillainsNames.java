import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class E01GetVillainsNames {

    private static final int MINIONS_TARGET_COUNT = 15;

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String COUNT_MINIONS_QUERY = "SELECT v.`name`, COUNT(DISTINCT(mv.`minion_id`)) AS 'minions_count'" +
            " FROM `villains` AS v" +
            " LEFT JOIN `minions_villains` AS mv" +
            " ON v.`id` = mv.`villain_id`" +
            " GROUP BY v.`id`" +
            " HAVING `minions_count` > ?" +
            " ORDER BY `minions_count` DESC";

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

        PreparedStatement statement = connection.prepareStatement(COUNT_MINIONS_QUERY);

        statement.setInt(1, MINIONS_TARGET_COUNT);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.println(result.getString("name") + " " + result.getString("minions_count"));
        }

        connection.close();

    }
}