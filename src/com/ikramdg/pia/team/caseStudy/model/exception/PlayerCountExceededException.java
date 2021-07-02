package com.ikramdg.pia.team.caseStudy.model.exception;

public class PlayerCountExceededException extends RuntimeException {

	public PlayerCountExceededException(String message) {
		super(message);
	}

	public PlayerCountExceededException() {
		super("Player count cannot exceed 18");
	}

}
