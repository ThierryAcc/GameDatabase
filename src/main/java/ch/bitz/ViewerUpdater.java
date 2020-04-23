package ch.bitz;

import ch.bitz.models.legacy.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ViewerUpdater {
	public static final String UPDATE_GAMES_SET_VIEWED_WHERE_ID = "UPDATE games SET viewed = ? WHERE id = ?";
	public static final String SELECT_VIEWED_FROM_GAMES_WHERE_ID = "SELECT viewed FROM games WHERE id = ?";

	DBConnectionManager dbConnectionManager = new DBConnectionManager();

	public void myupdate(List<Game> games) {
		Connection connection = dbConnectionManager.openConnection();

		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatementSelect = connection.prepareStatement("SELECT viewed FROM games WHERE id = ?");
			PreparedStatement preparedStatementUpdate = connection.prepareStatement("UPDATE games SET viewed = ? WHERE id = ?");

			for (Game game : games) {

				// setzte query
				preparedStatementSelect.setInt(1, game.getId());

				// führe query aus
				ResultSet resultSet = preparedStatementSelect.executeQuery();

				// wähle das game aus
				resultSet.next();

				// get viewed
				int viewed = resultSet.getInt("viewed");

				// set update query
				preparedStatementUpdate.setInt(1, ++viewed);
				preparedStatementUpdate.setInt(2, game.getId());

				// execute update query
				preparedStatementUpdate.execute();

				// objekt anpassen damit du nicht nochmals eine query machen musst
				game.setViewed(game.getViewed() + 1);

				System.out.println(game.getId() + " --- > " + game.getViewed());
				System.out.println(game.getId() + " --- > " + game.getViewed());
			}

			connection.commit();
			connection.setAutoCommit(true);
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			throw new RuntimeException(ex);
		}
	}

	public void update(List<Game> games) {

		Connection connection = dbConnectionManager.openConnection();
		try {
			connection.setAutoCommit(false);

			PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT_VIEWED_FROM_GAMES_WHERE_ID);
			PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE_GAMES_SET_VIEWED_WHERE_ID);

			for (Game game : games) {
				preparedStatementSelect.setInt(1, game.getId());
				ResultSet resultSet = preparedStatementSelect.executeQuery();
				resultSet.next();
				int viewed = resultSet.getInt("viewed");

				System.out.println("VIEWED -> " + viewed);

				preparedStatementUpdate.setInt(1, ++viewed);
				preparedStatementUpdate.setInt(2, game.getId());

				preparedStatementUpdate.execute();

				game.setViewed(game.getViewed() + 1);
				// query mit update absetzen
				System.out.println(game.getId() + " --- > " + game.getViewed());
			}

			connection.commit();
			connection.setAutoCommit(true);
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			throw new RuntimeException(ex);
		}

	}
}
