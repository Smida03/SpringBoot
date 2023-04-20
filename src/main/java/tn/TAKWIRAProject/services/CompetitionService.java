package tn.TAKWIRAProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.competition;
import tn.TAKWIRAProject.repository.CompetitionRepository;

@Service
public class CompetitionService {
	@Autowired
    private CompetitionRepository competitionRepository;

    public List<competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public competition getCompetitionById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    public competition createCompetition(competition competition) {
        return competitionRepository.save(competition);
    }

    public competition updateCompetition(Long id, competition competition) {
        competition existingCompetition = competitionRepository.findById(id).orElse(null);
        if (existingCompetition == null) {
            return null;
        }
        existingCompetition.setNom(competition.getNom());
        existingCompetition.setDescription(competition.getDescription());
        existingCompetition.setDateDebut(competition.getDateDebut());
        existingCompetition.setDateFin(competition.getDateFin());
        existingCompetition.setTerrain(competition.getTerrain());
        return competitionRepository.save(existingCompetition);
    }

    public boolean deleteCompetition(Long id) {
        competition existingCompetition = competitionRepository.findById(id).orElse(null);
        if (existingCompetition == null) {
            return false;
        }
        competitionRepository.delete(existingCompetition);
        return true;
    }
}
