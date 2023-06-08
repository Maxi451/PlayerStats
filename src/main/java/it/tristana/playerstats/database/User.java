package it.tristana.playerstats.database;

import java.util.UUID;

public class User {

	private volatile UUID uuid;
	private volatile String name;
	private volatile long firstLogin;
	private volatile long lastLogin;
	private volatile long lastLogout;
	private volatile long longestOnline;
	private volatile long lastMonth;
	private volatile long totalTime;

	private volatile boolean isLoaded;

	public User() {}

	public synchronized void load(UUID uuid, String name, long firstLogin, long lastLogin, long lastLogout, long longestOnline, long lastMonth, long totalTime) {
		this.uuid = uuid;
		this.name = name;
		this.firstLogin = firstLogin;
		this.lastLogin = lastLogin;
		this.lastLogout = lastLogout;
		this.longestOnline = longestOnline;
		this.lastMonth = lastMonth;
		this.totalTime = totalTime;
		this.isLoaded = true;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public long getFirstLogin() {
		return firstLogin;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public long getLastLogout() {
		return lastLogout;
	}

	public long getLongestOnline() {
		return longestOnline;
	}

	public long getLastMonth() {
		return lastMonth;
	}

	public long getTotalTime() {
		return getCurrentSessionTime() + totalTime;
	}

	public long getCurrentSessionTime() {
		return System.currentTimeMillis() - lastLogin;
	}

	public boolean isLoaded() {
		return isLoaded;
	}
}
