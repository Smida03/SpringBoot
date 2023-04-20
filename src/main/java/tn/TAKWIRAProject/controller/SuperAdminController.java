package tn.TAKWIRAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.TAKWIRAProject.entities.superadmin;
import tn.TAKWIRAProject.services.SuperAdminService;

@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {
    @Autowired
    private SuperAdminService superAdminService;

    @GetMapping("/")
    public ResponseEntity<List<superadmin>> getAllSuperAdmins() {
        List<superadmin> superAdmins = superAdminService.getAllSuperAdmins();
        return new ResponseEntity<>(superAdmins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<superadmin> getSuperAdminById(@PathVariable("id") Long id) {
        superadmin superAdmin = superAdminService.getSuperAdminById(id);
        if (superAdmin != null) {
            return new ResponseEntity<>(superAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<superadmin> addSuperAdmin(@RequestBody superadmin superAdmin) {
        superadmin newSuperAdmin = superAdminService.addSuperAdmin(superAdmin);
        return new ResponseEntity<>(newSuperAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<superadmin> updateSuperAdmin(@PathVariable("id") Long id, @RequestBody superadmin update) {
        superadmin existing = superAdminService.getSuperAdminById(id);
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
        superadmin updatedSuperAdmin = superAdminService.updateSuperAdmin(existing);
        return new ResponseEntity<>(updatedSuperAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperAdmin(@PathVariable("id") Long id) {
    	superadmin existingSuperadmin = superAdminService.getSuperAdminById(id);

        if (existingSuperadmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        superAdminService.deleteSuperAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
}