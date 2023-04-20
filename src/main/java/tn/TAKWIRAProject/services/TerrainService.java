package tn.TAKWIRAProject.services;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.TAKWIRAProject.entities.terrain;
import tn.TAKWIRAProject.repository.TerrainRepository;

@Service
public class TerrainService {
	@Autowired
    private TerrainRepository terrainRepository;

    public terrain saveTerrain(terrain terrain, MultipartFile imageFile) throws IOException {
        terrain.saveImage(imageFile);
        return terrainRepository.save(terrain);
    }

    public List<terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public terrain getTerrainById(Long id) {
        return terrainRepository.findById(id).orElse(null);
    }

    public List<terrain> getTerrainsByIdPartenaire(Long idPartenaire) {
        return terrainRepository.findByPartenaireId(idPartenaire);
    }

    public terrain updateTerrain(Long id, terrain terrain, MultipartFile imageFile) throws IOException {
        terrain terrainToUpdate = terrainRepository.findById(id).orElse(null);
        if (terrainToUpdate != null) {
            terrainToUpdate.setNomDeTerrain(terrain.getNomDeTerrain());
            terrainToUpdate.setDescription(terrain.getDescription());
            terrainToUpdate.setLocalisation(terrain.getLocalisation());
            terrainToUpdate.setPartenaire(terrain.getPartenaire());
            if (imageFile != null) {
                terrainToUpdate.saveImage(imageFile);
            }
            return terrainRepository.save(terrainToUpdate);
        } else {
            return null; // Terrain non trouvé
        }
    }

    public boolean deleteTerrain(Long id) {
        terrain terrainToDelete = terrainRepository.findById(id).orElse(null);
        if (terrainToDelete != null) {
            terrainRepository.delete(terrainToDelete);
            return true;
        } else {
            return false; // Terrain non trouvé
        }
    }
}