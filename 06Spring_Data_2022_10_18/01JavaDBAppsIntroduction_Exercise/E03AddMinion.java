import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class E03AddMinion {

    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";

    private static final String GET_TOWN_ID_BY_NAME = "SELECT `id` FROM `towns` WHERE `name` LIKE ?";

    private static final String INSERT_TOWN_INTO_TABLE_TOWNS = "INSERT into `towns` (`name`)" +
            " VALUES (?)";

    private static final String INSERT_MINION_INTO_TABLE_MINIONS = "INSERT INTO `minions` (`name`, `age`, `town_id`)" +
            " VALUES (?, ?, ?)";

    private static final String GET_MINION_ID_BY_NAME = "SELECT `id` FROM `minions` WHERE `name` LIKE ?";

    private static final String GET_VILLAIN_ID_BY_NAME = "SELECT `id` FROM `villains` WHERE `name` LIKE ?";

    private static final String INSERT_VILLAIN_INTO_TABLE_VILLAINS = "INSERT INTO `villains` (`name`, `evilness_factor`)" +
            " VALUES (?, ?);";

    private static final String SET_MINION_TO_BE_SERVANT_OF_THE_VILLAIN = "INSERT INTO `minions_villains` (`minion_id`, `villain_id`)" +
            " VALUES (?, ?)";

    private static final String DEFAULT_EVILNESS_FACTOR = "evil";

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

        String[] minionInfo = scanner.nextLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String[] villainInfo = scanner.nextLine().split("\\s+");

        String villainName = villainInfo[1];

        PreparedStatement townName = connection.prepareStatement(GET_TOWN_ID_BY_NAME);
        townName.setString(1, minionTown);
        ResultSet townID = townName.executeQuery();

        if (!townID.next()) {
            PreparedStatement addTown = connection.prepareStatement(INSERT_TOWN_INTO_TABLE_TOWNS);
            addTown.setString(1, minionTown);
            addTown.executeUpdate();
            townID = townName.executeQuery();
            townID.next();
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        PreparedStatement addMinion = connection.prepareStatement(INSERT_MINION_INTO_TABLE_MINIONS);
        addMinion.setString(1, minionName);
        addMinion.setInt(2, minionAge);
        addMinion.setInt(3, townID.getInt("id"));
        addMinion.executeUpdate();

        PreparedStatement getMinionID = connection.prepareStatement(GET_MINION_ID_BY_NAME);
        getMinionID.setString(1, minionName);
        ResultSet minionID = getMinionID.executeQuery();

        PreparedStatement villain = connection.prepareStatement(GET_VILLAIN_ID_BY_NAME);
        villain.setString(1, villainName);
        ResultSet villainID = villain.executeQuery();

        if (!villainID.next()) {
            PreparedStatement addVillain = connection.prepareStatement(INSERT_VILLAIN_INTO_TABLE_VILLAINS);
            addVillain.setString(1, villainName);
            addVillain.setString(2, DEFAULT_EVILNESS_FACTOR);
            addVillain.executeUpdate();
            villainID = villain.executeQuery();
            villainID.next();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        minionID.next();
        PreparedStatement minionToVillain = connection.prepareStatement(SET_MINION_TO_BE_SERVANT_OF_THE_VILLAIN);
        minionToVillain.setInt(1, minionID.getInt("id"));
        minionToVillain.setInt(2, villainID.getInt("id"));
        minionToVillain.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

        connection.close();

    }
}