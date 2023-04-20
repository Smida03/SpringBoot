package tn.TAKWIRAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.TAKWIRAProject.entities.competition;
import tn.TAKWIRAProject.services.CompetitionService;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("")
    public List<competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<competition> getCompetitionById(@PathVariable Long id) {
        competition competition = competitionService.getCompetitionById(id);
        if (competition == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(competition);
    }

    @PostMapping("")
    public ResponseEntity<competition> createCompetition(@RequestBody competition competition) {
        competition createdCompetition = competitionService.createCompetition(competition);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompetition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<competition> updateCompetition(@PathVariable Long id, @RequestBody competition competition) {
        competition updatedCompetition = competitionService.updateCompetition(id, competition);
        if (updatedCompetition == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCompetition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        boolean competitionDeleted = competitionService.deleteCompetition(id);
        if (!competitionDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
