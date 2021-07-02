package com.ikramdg.pia.team.caseStudy.model;

import java.util.Map;

import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.model.exception.FootballTeamNotExistException;
import com.ikramdg.pia.team.caseStudy.model.exception.IdentifierGenerationException;

public class FootballFederationRepoInMemory {

	private Map<Integer, FootballTeam> footballTeams;

	public void addTeam(FootballTeam footballTeam) {
		if (footballTeams.containsKey(footballTeam.getId())) {
			throw new IdentifierGenerationException();
		}
		footballTeams.put(footballTeam.getId(), footballTeam);
	}

	public void deleteTeam(int teamId) {
		if (!footballTeams.containsKey(teamId)) {
			throw new FootballTeamNotExistException();
		}
		footballTeams.remove(teamId);

	}

	public void updateTeam(int footballTeamId, FootballTeamBuilder footballTeamBuilder) {
		if (!footballTeams.containsKey(footballTeamId)) {
			throw new FootballTeamNotExistException();
		}
		FootballTeam newFootballTeam = new FootballTeam(footballTeamBuilder);
		footballTeams.put(footballTeamId, newFootballTeam);

	}

	public FootballTeam getFootballTeamById(int footballTeamId) {
		if (!footballTeams.containsKey(footballTeamId)) {
			throw new FootballTeamNotExistException();
		}
		return footballTeams.get(footballTeamId);
	}

}
