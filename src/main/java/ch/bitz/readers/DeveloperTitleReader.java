package ch.bitz.readers;

import ch.bitz.JdbcTemplate;

public class DeveloperTitleReader extends JdbcTemplate {
    @Override
    public String sql() {
        return "SELECT g.title as gameTitle, d.title as developerTitle " +
                "FROM games g," +
                "     developers d," +
                "     games_developers gd " +
                " WHERE g.id = game_id " +
                " AND gd.developer_id = d.id";
    }
}
