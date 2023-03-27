import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class E06PrintAllMinionNames {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String GET_LIST_OF_MINIONS_NAMES = "SELECT `name` FROM `minions`";

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

        PreparedStatement minionsStatement = connection.prepareStatement(GET_LIST_OF_MINIONS_NAMES);
        ResultSet minionsList = minionsStatement.executeQuery();

        List<String> minionsNames = new ArrayList<>();

        while (minionsList.next()) {
            minionsNames.add(minionsList.getString("name"));
        }

        for (int i = 0; i <= minionsNames.size() / 2; i++) {
            System.out.println(minionsNames.get(i));
            if (i < minionsNames.size() - minionsNames.size() / 2 - 1) {
                System.out.println(minionsNames.get(minionsNames.size() - i - 1));
            }
        }

        connection.close();
    }
}