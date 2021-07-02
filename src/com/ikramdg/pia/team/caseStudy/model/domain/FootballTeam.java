package com.ikramdg.pia.team.caseStudy.model.domain;

import java.awt.Color;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.ikramdg.pia.team.caseStudy.util.IdentifierGenerator;

public class FootballTeam {

	private int id;
	private String name;
	private League league;
	private String teamLogoURL;
	private String homeCity;
	private Year foundationYear;
	private List<Color> colors;
	private int nonHomeGrownPlayerNumber;
	private int goalKeeperNumber;

	private List<FootballPlayer> footballPlayers = new ArrayList<FootballPlayer>();

	public FootballTeam(String name, League league, String teamLogoURL, String homeCity, Year foundationYear,
			List<Color> colors) {
		this.name = name;
		this.league = league;
		this.teamLogoURL = teamLogoURL;
		this.homeCity = homeCity;
		this.foundationYear = foundationYear;
		this.colors = colors;
		this.id = IdentifierGenerator.generateId();
	}

	public FootballTeam(FootballTeamBuilder footballTeamBuilder) {
		this.name = footballTeamBuilder.name;
		this.league = footballTeamBuilder.league;
		this.teamLogoURL = footballTeamBuilder.teamLogoURL;
		this.homeCity = footballTeamBuilder.homeCity;
		this.foundationYear = footballTeamBuilder.foundationYear;
		this.colors = footballTeamBuilder.colors;
	}

	public FootballTeam() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public String getTeamLogoURL() {
		return teamLogoURL;
	}

	public void setTeamLogoURL(String teamLogoURL) {
		this.teamLogoURL = teamLogoURL;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public Year getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Year foundationYear) {
		this.foundationYear = foundationYear;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public void increaseGoalkeeperNumber() {
		goalKeeperNumber++;
	}

	public void increaseNonHomegrownPlayerNumber() {
		nonHomeGrownPlayerNumber++;
	}

	public boolean ensureTeamCount() {
		return footballPlayers.size() + 1 <= 18;
	}

	public boolean ensureNonHomegrownPlayerNumber() {
		return nonHomeGrownPlayerNumber < 6;
	}

	public boolean ensureGoalkeeperNumber() {
		return goalKeeperNumber < 2;
	}

	public List<FootballPlayer> getFootballPlayers() {
		return footballPlayers;
	}

	public static class FootballTeamBuilder {
		private String name;
		private League league;
		private String teamLogoURL;
		private String homeCity;
		private Year foundationYear;
		private List<Color> colors;
		private int nonHomeGrownPlayerNumber;

		public void setName(String name) {
			this.name = name;
		}

		public void setLeague(League league) {
			this.league = league;
		}

		public void setTeamLogoURL(String teamLogoURL) {
			this.teamLogoURL = teamLogoURL;
		}

		public void setHomeCity(String homeCity) {
			this.homeCity = homeCity;
		}

		public void setFoundationYear(Year foundationYear) {
			this.foundationYear = foundationYear;
		}

		public void setColors(List<Color> colors) {
			this.colors = colors;
		}

		public void setNonHomeGrownPlayerNumber(int nonHomeGrownPlayerNumber) {
			this.nonHomeGrownPlayerNumber = nonHomeGrownPlayerNumber;
		}

	}

}
