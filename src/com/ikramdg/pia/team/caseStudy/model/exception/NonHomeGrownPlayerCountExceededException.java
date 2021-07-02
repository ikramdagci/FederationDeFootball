package com.ikramdg.pia.team.caseStudy.model.exception;

public class NonHomeGrownPlayerCountExceededException extends RuntimeException{
	
	public NonHomeGrownPlayerCountExceededException() {
		super("Non-homegrown player count cannot exceed 6");
	}

}
