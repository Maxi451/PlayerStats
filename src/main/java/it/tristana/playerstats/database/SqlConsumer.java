package it.tristana.playerstats.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlConsumer {

	void accept(ResultSet resultSet) throws SQLException;
}
