package ch.bitz.rowmappers;

import ch.bitz.models.legacy.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRowMapper {
    public List<Game> createGames(ResultSet resultSet) {
        List<Game> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Game game = new Game();
                game.setViewed(resultSet.getInt("gameViewed"));
                game.setId(resultSet.getInt("gameId"));
                game.setPlatform(resultSet.getString("platformTitle"));
                game.setGameTitle(resultSet.getString("gameTitle"));
                result.add(game);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
