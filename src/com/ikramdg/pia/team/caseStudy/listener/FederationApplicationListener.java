package com.ikramdg.pia.team.caseStudy.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ikramdg.pia.team.caseStudy.model.FootballFederationRepoInMemory;
import com.ikramdg.pia.team.caseStudy.model.core.FootballTeamServiceImpl;
import com.ikramdg.pia.team.caseStudy.util.IdentifierGenerator;

@WebListener
public class FederationApplicationListener implements ServletContextListener {

	private FootballFederationRepoInMemory repoInMemory;
	private File persistedIdFile;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		persistedIdFile = new File("id_generator_last_id");
		setLastId();

		repoInMemory = new FootballFederationRepoInMemory();
		FootballTeamServiceImpl footballTeamService = new FootballTeamServiceImpl(repoInMemory);

		sce.getServletContext().setAttribute("repoInMemory", repoInMemory);
		sce.getServletContext().setAttribute("footballTeamService", footballTeamService);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		persistLastIdOnSecondaryMemory();
	}

	
	
	
	
	private void setLastId() {

		try {
			Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(persistedIdFile)));

			StringBuilder readInt = new StringBuilder();

			int c = 0;
			while ((c = reader.read()) != -1) {
				readInt.append(Integer.toBinaryString(c));
			}
			IdentifierGenerator.setLastId(Integer.parseInt(readInt.toString(), 2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void persistLastIdOnSecondaryMemory() {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(persistedIdFile)))) {

			int lastId = IdentifierGenerator.generateId() - 1;
			writer.write(lastId);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
