package tn.TAKWIRAProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="partenaire")
public class partenaire extends utilisateur {
	@JsonIgnore
	@OneToMany(mappedBy="partenaire", cascade = CascadeType.ALL)
	private List<terrain> terrains = new ArrayList<>();
	public partenaire() {
	}

	public partenaire(Long idClient, String nom, String prenom, String nomUtilisateur, String motDePasse,
			String confirmationMotDePasse, String email, String phone, String adresse, String pays) {
		super(idClient, nom, prenom, nomUtilisateur, motDePasse, confirmationMotDePasse, email, phone, adresse, pays);
	}
	public List<terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<terrain> terrains) {
		this.terrains = terrains;
	}

	public void addTerrain(terrain terrain) {
		terrains.add(terrain);
		terrain.setPartenaire(this);
	}
	
	public void removeTerrain(terrain terrain) {
		terrains.remove(terrain);
		terrain.setPartenaire(null);
	}   
	
}
