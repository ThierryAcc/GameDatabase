package ch.bitz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    // Pure: DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/mygames")
    public Connection openConnection() {
        Connection connection;

        try {
            connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://root:root@localhost:3306/furious_games?serverTimezone=Europe/Berlin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
