package ch.bitz.rowmappers;

import ch.bitz.models.legacy.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRowMapper {

	/**
	 * erstelle neue ARRAYLISTE
	 * iteriere über das SET
	 * erstelle ein Objekt DEVELOPER
	 * MAPPE Daten auf das Objekt über set.getString("devTitle");
	 * adde objekt zur liste devList
	 * @param resultSet
	 * @return Liste<Developer>
	 */
    public List<Developer> createDevelopers(ResultSet resultSet) {
        List<Developer> devList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setDeveloperName(resultSet.getString("developerTitle"));
                developer.setGameTitle(resultSet.getString("gameTitle"));
                devList.add(developer);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return devList;
    }

}
