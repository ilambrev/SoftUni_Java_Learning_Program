import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class E05RemoveVillain {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String FIND_VILLAIN_NAME_BY_ID = "SELECT `name` FROM `villains` WHERE `id` = ?;";

    private static final String RELEASE_MINIONS_FROM_SERVING_VILLAIN = "DELETE FROM `minions_villains`" +
            " WHERE `villain_id` = ?";

    private static final String DELETE_VILLAIN_FROM_DB = "DELETE FROM `villains`" +
            " WHERE `id` = ?;";

    public static void main(String[] args) {

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

        int villainID = Integer.parseInt(scanner.nextLine());

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION_PATH, properties);
            connection.setAutoCommit(false);

            PreparedStatement getVillainName = connection.prepareStatement(FIND_VILLAIN_NAME_BY_ID);
            getVillainName.setInt(1, villainID);

            ResultSet result = getVillainName.executeQuery();

            if (result.next()) {
                String villainName = result.getString("name");

                PreparedStatement releaseMinions = connection.prepareStatement(RELEASE_MINIONS_FROM_SERVING_VILLAIN);
                releaseMinions.setInt(1, villainID);
                int releasedMinionsCount = releaseMinions.executeUpdate();

                PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN_FROM_DB);
                deleteVillain.setInt(1, villainID);
                deleteVillain.executeUpdate();

                connection.commit();

                System.out.printf("%s was deleted%n", villainName);
                System.out.printf("%d minions released%n", releasedMinionsCount);

            } else {
                System.out.println("No such villain was found");
                connection.rollback();
            }

        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}