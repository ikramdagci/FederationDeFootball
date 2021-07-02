package com.ikramdg.pia.team.caseStudy.util;

public class IdentifierGenerator {

	private static int generatedId;

	public static int generateId() {
		return ++generatedId;
	}

	public static void setLastId(int id) {
		generatedId = id;

	}

}
