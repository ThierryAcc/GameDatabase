package ch.bitz;

import java.sql.*;

/**
 * States: DBConnection, connection
 * Methods: openConnection, executeQuery, closeConnection
 * @author thierry.bitz
 *
 */
public abstract class JdbcTemplate {
    DBConnectionManager dbConnectionManager = new DBConnectionManager();
    Connection connection;

    public void openConnection() {
        if(connection == null) {
            connection = dbConnectionManager.openConnection();
        }
    }

    // connection öffnen, statement kreiieren, statement führt query mit sql string aus
    public ResultSet executeQuery() {
        openConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeQuery(sql());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String sql();

    public void closeConnection() {
        dbConnectionManager.closeConnection(connection);
    }


}
