package tn.TAKWIRAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.TAKWIRAProject.entities.publicite;
import tn.TAKWIRAProject.services.IPubliciteService;

@RestController
@RequestMapping("/publicite")
public class PubliciteController {
	
	@Autowired
    private IPubliciteService publiciteService;

    @PostMapping("/{adminm_id}")
    public ResponseEntity<publicite> addPublicite(@RequestBody publicite pub, @PathVariable("adminm_id") Long adminm_id) {
        return new ResponseEntity<>(publiciteService.addPublicite(pub, adminm_id), HttpStatus.CREATED);
    }

    @GetMapping("/{adminm_id}")
    public ResponseEntity<List<publicite>> getAllPublicitesByAdminMarketing(@PathVariable("adminm_id") Long adminm_id) {
        return new ResponseEntity<>(publiciteService.getAllPublicitesByAdminMarketing(adminm_id), HttpStatus.OK);
    }

    @GetMapping("/{adminm_id}/{publicite_id}")
    public ResponseEntity<publicite> getPubliciteByAdminMarketing(@PathVariable("adminm_id") Long adminm_id, @PathVariable("publicite_id") Long publicite_id) {
        return new ResponseEntity<>(publiciteService.getPubliciteByAdminMarketing(adminm_id, publicite_id), HttpStatus.OK);
    }

    @PutMapping("/{adminm_id}/{publicite_id}")
    public ResponseEntity<publicite> updatePubliciteByAdminMarketing(@PathVariable("adminm_id") Long adminm_id, @PathVariable("publicite_id") Long publicite_id, @RequestBody publicite pub) {
        return new ResponseEntity<>(publiciteService.updatePubliciteByAdminMarketing(adminm_id, publicite_id, pub), HttpStatus.OK);
    }

    @DeleteMapping("/{adminm_id}/{publicite_id}")
    public ResponseEntity<Void> deletePubliciteByAdminMarketing(@PathVariable("adminm_id") Long adminm_id, @PathVariable("publicite_id") Long publicite_id) {
        publiciteService.deletePubliciteByAdminMarketing(adminm_id, publicite_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}