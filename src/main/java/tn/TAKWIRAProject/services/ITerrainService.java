package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.terrain;

public interface ITerrainService {
	public terrain saveTerrain(terrain terrain);
	public List<terrain> getAllTerrains();
	public terrain getTerrainById(Long id);
	public List<terrain> getTerrainsByIdPartenaire(Long idPartenaire);
	public terrain updateTerrain(terrain terrain);
	public void deleteTerrain(Long id);
}
