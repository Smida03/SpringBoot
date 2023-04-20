package tn.TAKWIRAProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import tn.TAKWIRAProject.entities.partenaire;
import tn.TAKWIRAProject.entities.terrain;
import tn.TAKWIRAProject.repository.PartenaireRepository;
import tn.TAKWIRAProject.services.TerrainService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/terrain")
public class TerrainController {
	@Autowired
    private TerrainService terrainService;

	@Autowired
	private PartenaireRepository partenaireRepository;
	 
	@PostMapping("/{idPartenaire}")
	public ResponseEntity<terrain> saveTerrain(@PathVariable("idPartenaire") Long idPartenaire,
	                                            @RequestParam("image") MultipartFile imageFile,
	                                            @RequestParam("nomDeTerrain") String nomDeTerrain,
	                                            @RequestParam("description") String description,
	                                            @RequestParam("localisation") String localisation) throws IOException {
	    terrain terrain = new terrain();
	    terrain.setNomDeTerrain(nomDeTerrain);
	    terrain.setDescription(description);
	    terrain.setLocalisation(localisation);
	    partenaire partenaire = partenaireRepository.findById(idPartenaire).orElse(null);
	    if (partenaire != null) {
	        terrain.setPartenaire(partenaire);
	        terrain savedTerrain = terrainService.saveTerrain(terrain, imageFile);
	        return new ResponseEntity<>(savedTerrain, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
    @GetMapping("/")
    public List<terrain> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<terrain> getTerrainById(@PathVariable("id") Long id) {
        terrain terrain = terrainService.getTerrainById(id);
        if (terrain != null) {
            return new ResponseEntity<>(terrain, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/partenaire/{idPartenaire}")
    public List<terrain> getTerrainsByIdPartenaire(@PathVariable("idPartenaire") Long idPartenaire) {
        return terrainService.getTerrainsByIdPartenaire(idPartenaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<terrain> updateTerrain(@PathVariable("id") Long id,
                                                   @RequestParam(value = "image", required = false) MultipartFile imageFile,
                                                   @RequestParam("nomDeTerrain") String nomDeTerrain,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("localisation") String localisation) throws IOException {
        terrain terrain = terrainService.getTerrainById(id); // Récupérer le terrain existant à partir de son ID
        if (terrain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        terrain.setNomDeTerrain(nomDeTerrain);
        terrain.setDescription(description);
        terrain.setLocalisation(localisation);
        terrain updatedTerrain = terrainService.updateTerrain(id, terrain, imageFile);
        if (updatedTerrain != null) {
            return new ResponseEntity<>(updatedTerrain, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTerrain(@PathVariable("id") Long id) {
        boolean deleted = terrainService.deleteTerrain(id);
        if (deleted) {
            return new ResponseEntity<>("Terrain deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Terrain not found", HttpStatus.NOT_FOUND);
        }
    }
}
