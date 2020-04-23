package ch.bitz;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ch.bitz.models.Genre;
import ch.bitz.models.Publisher;
import ch.bitz.models.legacy.Developer;
import ch.bitz.models.legacy.Game;
import ch.bitz.readers.DeveloperTitleReader;
import ch.bitz.readers.GameTitleReader;
import ch.bitz.rowmappers.DeveloperRowMapper;
import ch.bitz.rowmappers.GameRowMapper;

public class App_JDBC {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        ArrayList ar = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ar.add(i);
        }
        new App_JDBC().execute(args);
    }

    private void execute(String[] args) {
        if ("developers".equalsIgnoreCase(args[0])) {

        	// reader mit jdbc static type
            JdbcTemplate reader = new DeveloperTitleReader();
            try {
            	
            	// der reader liest mit der executeQuery sein sql raus und bekommt ein resulset
                ResultSet resultSet = reader.executeQuery();
                
                // übergib das set und du bekommst eine List von Developers
                List<Developer> developers = new DeveloperRowMapper().createDevelopers(resultSet);
                
                // daten ausgeben
                outputDeveloperResultSet(developers);
            } finally {
                reader.closeConnection();
            }
        } else {
            printGames();
        }
    }

    private void printGames() {
        JdbcTemplate reader = new GameTitleReader();
        try {
            ResultSet resultSet = reader.executeQuery();
            List<Game> games = new GameRowMapper().createGames(resultSet);
            outputResultSet(games);

            new ViewerUpdater().myupdate(games);
        } finally {
            reader.closeConnection();
        }
    }

    private static void outputDeveloperResultSet(List<Developer> developers) {
        developers.forEach((developer ->
                System.out.println("DEV: " + developer.getDeveloperName() + ": " +developer.getGameTitle())));
    }

    private static void outputResultSet(List<Game> games) {
        games.forEach((game ->
                System.out.println("GAME: " + game.getGameTitle() + ": " +game.getPlatform() + " : " + game.getViewed())));
    }
}
