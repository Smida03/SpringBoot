package tn.TAKWIRAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.TAKWIRAProject.entities.partenaire;
import tn.TAKWIRAProject.services.IPartenaireService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/partenaire")
public class PartenaireController {

    @Autowired
    private IPartenaireService partenaireService;
    @GetMapping("/")
    public ResponseEntity<List<partenaire>> getAllPartenaires() {
        List<partenaire> partenaires = partenaireService.getAllPartenaires();
        return new ResponseEntity<>(partenaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<partenaire> getPartenaireById(@PathVariable("id") Long id) {
        partenaire Partenaire = partenaireService.getPartenaireById(id);

        if (Partenaire == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Partenaire, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<partenaire> addPartenaire(@RequestBody partenaire Partenaire) {
        partenaire addedPartenaire = partenaireService.addPartenaire(Partenaire);
        return new ResponseEntity<>(addedPartenaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<partenaire> updatePartenaire(@PathVariable("id") Long id, @RequestBody partenaire update) {
        partenaire existing = partenaireService.getPartenaireById(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (update.getNom() != null) {
            existing.setNom(update.getNom());
        }
        if (update.getPrenom() != null) {
            existing.setPrenom(update.getPrenom());
        }
        if (update.getMotDePasse() != null) {
            existing.setMotDePasse(update.getMotDePasse());
        }
        if (update.getConfirmationMotDePasse() != null) {
            existing.setConfirmationMotDePasse(update.getConfirmationMotDePasse());
        }
        if (update.getPhone() != null) {
            existing.setPhone(update.getPhone());
        }
        if (update.getAdresse() != null) {
            existing.setAdresse(update.getAdresse());
        }
        if (update.getPays() != null) {
            existing.setPays(update.getPays());
        }
        partenaire updatedPartenaire = partenaireService.updatePartenaire(existing);
        return new ResponseEntity<>(updatedPartenaire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartenaire(@PathVariable("id") Long id) {
        partenaire existingPartenaire = partenaireService.getPartenaireById(id);

        if (existingPartenaire == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            partenaireService.deletePartenaire(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/addutilisateurRole/{id}/{idRole}")
    public partenaire addutilisateurRole(@PathVariable("id") Long id, @PathVariable("idRole") Long idRole) {
    	return partenaireService.addutilisateurRole(id, idRole);
    }
}