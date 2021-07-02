package com.ikramdg.pia.team.caseStudy.model.core;

import java.util.List;

import com.ikramdg.pia.team.caseStudy.model.FootballFederationRepoInMemory;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballPlayer;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.Position;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.model.exception.GoalKeeperCountExceededException;
import com.ikramdg.pia.team.caseStudy.model.exception.NonHomeGrownPlayerCountExceededException;
import com.ikramdg.pia.team.caseStudy.model.exception.PlayerCountExceededException;

public class FootballTeamServiceImpl implements FootballTeamService {

	private FootballFederationRepoInMemory repoInMemory;

	public FootballTeamServiceImpl(FootballFederationRepoInMemory repoInMemory) {
		this.repoInMemory = repoInMemory;
	}

	public FootballTeamServiceImpl() {
		this(new FootballFederationRepoInMemory());
	}

	@Override
	public void deletePlayer(int footballTeamId, int footBallPlayerId) {
		FootballTeam footballTeam = repoInMemory.getFootballTeamById(footballTeamId);
		List<FootballPlayer> footballPlayers = footballTeam.getFootballPlayers();
		for (FootballPlayer player : footballPlayers) {
			if (player.getId() == footBallPlayerId) {
				footballPlayers.remove(player);
			}
		}

	}

	@Override
	public List<FootballPlayer> getAllPlayers(int footbalTeamId) {
		return repoInMemory.getFootballTeamById(footbalTeamId).getFootballPlayers();
	}

	@Override
	public void deleteTeam(int footballTeamId) {
		repoInMemory.deleteTeam(footballTeamId);
	}

	@Override
	public void updateTeam(int footballTeamId, FootballTeamBuilder footballTeamBuilder) {
		repoInMemory.updateTeam(footballTeamId, footballTeamBuilder);
	}

	@Override
	public void addPlayer(int footballTeamId, FootballPlayer footballPlayer) {
		FootballTeam footballTeam = repoInMemory.getFootballTeamById(footballTeamId);
		if (!footballTeam.ensureTeamCount())
			throw new PlayerCountExceededException();
		if (!footballPlayer.isHomegrown()) {
			if (!footballTeam.ensureNonHomegrownPlayerNumber())
				throw new NonHomeGrownPlayerCountExceededException();
			footballTeam.increaseNonHomegrownPlayerNumber();
			;
		}
		if (footballPlayer.getPosition() == Position.GOALKEEPER) {
			if (!footballTeam.ensureGoalkeeperNumber())
				throw new GoalKeeperCountExceededException();
			footballTeam.increaseGoalkeeperNumber();
		}
		footballTeam.getFootballPlayers().add(footballPlayer);
	}

	@Override
	public void addTeam(FootballTeam footballTeam) {
		repoInMemory.addTeam(footballTeam);
	}

}
