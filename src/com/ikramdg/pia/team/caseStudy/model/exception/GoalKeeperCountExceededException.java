package com.ikramdg.pia.team.caseStudy.model.exception;

public class GoalKeeperCountExceededException extends RuntimeException{

	public GoalKeeperCountExceededException() {
		super("Goalkeeper count cannot exceed 2");
	}
}
