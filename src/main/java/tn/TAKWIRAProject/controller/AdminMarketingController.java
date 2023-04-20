package tn.TAKWIRAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.TAKWIRAProject.entities.adminmarketing;
import tn.TAKWIRAProject.services.AdminMarketingService;

@RestController
@RequestMapping("/adminmarketing")
public class AdminMarketingController {
    
    @Autowired
    private AdminMarketingService adminMarketingService;

    @GetMapping("/")
    public ResponseEntity<List<adminmarketing>> getAllAdminMarketings() {
        List<adminmarketing> adminMarketings = adminMarketingService.getAllAdminMarketing();
        return new ResponseEntity<>(adminMarketings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<adminmarketing> getAdminMarketingById(@PathVariable("id") Long id) {
        adminmarketing adminMarketing = adminMarketingService.getAdminMarketingById(id);
        if (adminMarketing != null) {
            return new ResponseEntity<>(adminMarketing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<adminmarketing> addAdminMarketing(@RequestBody adminmarketing adminMarketing) {
        adminmarketing newAdminMarketing = adminMarketingService.addAdminMarketing(adminMarketing);
        return new ResponseEntity<>(newAdminMarketing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<adminmarketing> updateAdminMarketing(@PathVariable("id") Long id, @RequestBody adminmarketing update) {
        adminmarketing existing = adminMarketingService.getAdminMarketingById(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (update.getNom() != null) {
            existing.setNom(update.getNom());
        }
        if (update.getPrenom() != null) {
            existing.setPrenom(update.getPrenom());
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
        adminmarketing updateAdminmarketing = adminMarketingService.updateAdminMarketing(existing);
        return new ResponseEntity<>(updateAdminmarketing, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdminMarketing(@PathVariable("id") Long id) {
    	adminmarketing existinAdminmarketing = adminMarketingService.getAdminMarketingById(id);

        if (existinAdminmarketing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        adminMarketingService.deleteAdminMarketing(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    @PostMapping("/addAdminMarketingRole/{id}/{idRole}")
    public adminmarketing addAdminMarketingRole(@PathVariable("id") Long id, @PathVariable("idRole") Long idRole) {
    	return adminMarketingService.addAdminMarketingRole(id, idRole);
    }
}