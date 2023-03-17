import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class E07IncreaseMinionsAge {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String LIST_OF_ALL_MINIONS_NAMES_AND_AGE = "SELECT `name`, `age` FROM `minions`";

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

        int[] rangeOfIDs = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        StringBuilder parameters = new StringBuilder();
        parameters.append("(?");

        for(int i = 1; i < rangeOfIDs.length; i++) {
            parameters.append(", ?");
        }

        parameters.append(")");

        final String UPDATE_MINIONS_AGE = "UPDATE `minions`\n" +
                " SET `age` = `age` + 1, `name` = LOWER(`name`)\n" +
                " WHERE `id` IN " + parameters;

        Connection connection = DriverManager.getConnection(DB_CONNECTION_PATH, properties);

        PreparedStatement updateMinionsStatement = connection.prepareStatement(UPDATE_MINIONS_AGE);
        for (int i = 1; i <= rangeOfIDs.length; i++) {
            updateMinionsStatement.setInt(i, rangeOfIDs[i - 1]);
        }
        updateMinionsStatement.executeUpdate();

        PreparedStatement minionsStatement = connection.prepareStatement(LIST_OF_ALL_MINIONS_NAMES_AND_AGE);
        ResultSet listOfMinions = minionsStatement.executeQuery();

        while (listOfMinions.next()) {
            System.out.println(listOfMinions.getString("name") + " " + listOfMinions.getString("age"));
        }

        connection.close();

    }
}