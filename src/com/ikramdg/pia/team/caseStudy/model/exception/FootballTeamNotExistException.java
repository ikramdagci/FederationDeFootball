package com.ikramdg.pia.team.caseStudy.model.exception;

public class FootballTeamNotExistException extends RuntimeException {

	public FootballTeamNotExistException() {
		super("Football Team cannot find");
	}

}
