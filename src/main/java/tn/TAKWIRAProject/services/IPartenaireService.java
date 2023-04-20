package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.partenaire;


public interface IPartenaireService {
	public List<partenaire> getAllPartenaires();
	public partenaire getPartenaireById(Long id);
	public partenaire addPartenaire(partenaire Partenaire);
	public partenaire updatePartenaire(partenaire Partenaire);
	public void deletePartenaire(Long id);
	 public partenaire addutilisateurRole(Long id, Long idRole);
}
