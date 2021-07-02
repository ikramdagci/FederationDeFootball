package com.ikramdg.pia.team.caseStudy.servlet;

import java.awt.Color;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam;
import com.ikramdg.pia.team.caseStudy.model.domain.FootballTeam.FootballTeamBuilder;
import com.ikramdg.pia.team.caseStudy.model.domain.League;
import com.ikramdg.pia.team.caseStudy.model.core.FootballTeamService;

@WebServlet(name = "addFootbalTeam", urlPatterns = { "/add_team" })
public class AddFootballTeamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FootballTeam footballTeam = getFootballTeamFromParameters(req);

		FootballTeamService service = (FootballTeamService) getServletContext().getAttribute("footballTeamService");
		service.addTeam(footballTeam);

	}

	private FootballTeam getFootballTeamFromParameters(HttpServletRequest req) {
		String footballTeamName = req.getParameter("footballTeamName");
		League league = com.ikramdg.pia.team.caseStudy.model.domain.League.valueOf(req.getParameter("League"));
		Year foundationYear = Year.of(Integer.valueOf(req.getParameter("foundationYear")));
		String teamLogoURL = req.getParameter("teamLogoURL");
		String homeCity = req.getParameter("homeCity");
		List<Color> colors = initializeColors(req.getParameter("colors"));

		return new FootballTeam(footballTeamName, league, teamLogoURL, homeCity, foundationYear, colors);

	}

	private List<Color> initializeColors(String colors) {
		List<Color> colorList = new ArrayList<Color>();
		String[] splittedColors = colors.split(" ");
		for (String string : splittedColors) {
			colorList.add(Color.getColor(string));
		}

		return colorList;
	}

}
