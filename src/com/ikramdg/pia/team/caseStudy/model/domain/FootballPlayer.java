package com.ikramdg.pia.team.caseStudy.model.domain;

import com.ikramdg.pia.team.caseStudy.util.IdentifierGenerator;

public class FootballPlayer {

	private int id;
	private String firstName;
	private String lastName;
	private Position position;
	private String number;
	private boolean isHomegrown;

	public FootballPlayer(String firstName, String lastName, Position position, String number, boolean isHomegrown) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.number = number;
		this.isHomegrown = isHomegrown;
		this.id = IdentifierGenerator.generateId();
	}

	public FootballPlayer() {
		this("UNKNOWN", "UNKNOWN", null, "0", false);
	}

	public int getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "FootballPlayer [firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", number=" + number + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FootballPlayer) {
			FootballPlayer otherPlayer = (FootballPlayer) obj;
			return otherPlayer.id == this.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public boolean isHomegrown() {
		return isHomegrown;
	}

}
