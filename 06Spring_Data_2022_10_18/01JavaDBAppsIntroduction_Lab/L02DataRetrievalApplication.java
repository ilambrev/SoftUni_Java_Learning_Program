import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class L02DataRetrievalApplication {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username (Default root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT u.`first_name`, " +
                        "u.`last_name`, " +
                        "(SELECT COUNT(ug.`user_id`) FROM `users_games` AS ug WHERE ug.`user_id` = u.`id`) AS 'games_count'\n" +
                        "FROM `users` AS u\n" +
                        "WHERE u.`user_name` = ?");

        String name = scanner.nextLine();
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("User: " + name);
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")
                    + " has played " + rs.getString("games_count") + " games");
        } else {
            System.out.println("No such user exists");
        }

        connection.close();


    }
}