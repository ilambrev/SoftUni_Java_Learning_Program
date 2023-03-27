import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class E08IncreaseAgeStoredProcedure {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String UPDATE_PROCEDURE_CALL = "{CALL usp_get_older(?)}";

    private static final String MINION_BY_ID = "SELECT `name`, `age` FROM `minions` WHERE `id` = ?";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.println();

        System.out.print("Enter password default (empty): ");
        String password = scanner.nextLine();

        System.out.println();

        System.out.print("Enter minion ID: ");
        int minionID = Integer.parseInt(scanner.nextLine());

        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(DB_CONNECTION_PATH, properties);

        PreparedStatement updateStatement = connection.prepareStatement(UPDATE_PROCEDURE_CALL);
        updateStatement.setInt(1, minionID);
        updateStatement.executeUpdate();

        PreparedStatement selectStatement = connection.prepareStatement(MINION_BY_ID);
        selectStatement.setInt(1, minionID);
        ResultSet minionName = selectStatement.executeQuery();

        if(minionName.next()) {
            System.out.println(minionName.getString("name") + " " + minionName.getString("age"));
        }

        connection.close();

    }
}