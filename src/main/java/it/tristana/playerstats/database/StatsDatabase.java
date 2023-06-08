package it.tristana.playerstats.database;

import java.sql.SQLException;
import java.util.UUID;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StatsDatabase extends BasicDatabase {

	private final String tablePlayers;
	private final String tableTimes;
	
	public StatsDatabase(String host, String database, String username, String password, int port, String tablePlayers, String tableTimes) {
		super(host, database, username, password, port);
		this.tablePlayers = tablePlayers;
		this.tableTimes = tableTimes;
	}

	@Override
	public void createTables() throws SQLException {
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tablePlayers + " ("
				+ " uuid CHAR(36) PRIMARY KEY,"
				+ " name VARCHAR(16) NOT NULL,"
				+ " first_login BIGINT NOT NULL,"
				+ " last_login BIGINT NOT NULL,"
				+ " last_logout BIGINT NOT NULL,"
				+ " longest_online BIGINT NOT NULL,"
				+ " last_month BIGINT NOT NULL,"
				+ " total_time BIGINT NOT NULL"
				+ " );");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableTimes + " ("
				+ " id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ " uuid CHAR(36) NOT NULL,"
				+ " login BIGINT NOT NULL,"
				+ " time BIGINT NOT NULL,"
				+ " FOREIGN KEY (uuid) REFERENCES " + tablePlayers + "(uuid)"
				+ " ON UPDATE CASCADE ON DELETE CASCADE"
				+ " );");
	}
	
	public void retrieveUser(ProxiedPlayer player, SqlConsumer action) {
		
	}
	
	public void retrieveUser(UUID uuid, SqlConsumer action) {
		
	}
	
	public void retrieveUser(String name, SqlConsumer action) {
		
	}
}
