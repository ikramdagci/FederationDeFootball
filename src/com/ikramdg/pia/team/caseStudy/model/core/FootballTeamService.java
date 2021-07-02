package com.ikramdg.pia.team.caseStudy.model.core;

import java.util.List;

import com.ikramdg.pia.team.caseStudy.model.domain.FootballPlayer;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;

public interface FootballTeamService {

	void addPlayer(int footballTeamId, FootballPlayer footballPlayer);

	void deletePlayer(int footballTeamId, int footBallPlayerId);

	List<FootballPlayer> getAllPlayers(int footbalTeamId);

	void addTeam(FootballTeam footballTeam);

	void deleteTeam(int footballTeamId);

	void updateTeam(int footballTeamId, FootballTeamBuilder footballTeamBuilder);

}
