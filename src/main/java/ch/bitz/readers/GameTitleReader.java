package ch.bitz.readers;

import ch.bitz.JdbcTemplate;

public class GameTitleReader extends JdbcTemplate {
    @Override
    public String sql() {
        return "SELECT  g.title as gameTitle, " +
                "       p.title as platformTitle, " +
                "       g.viewed as gameViewed, " +
                "       g.id as gameId " +
                "FROM games g, " +
                "     platforms p, " +
                "     games_platforms gp " +
                "WHERE g.id = gp.game_id " +
                "AND gp.platform_id = p.id ";
    }
}
