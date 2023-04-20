package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.competition;

public interface ICompetitionService {

	public List<competition> getAllCompetitions();
	public competition getCompetitionById(Long id);
	public competition createCompetition(competition competition);
	public competition updateCompetition(Long id, competition competition);
	public boolean deleteCompetition(Long id);
}
