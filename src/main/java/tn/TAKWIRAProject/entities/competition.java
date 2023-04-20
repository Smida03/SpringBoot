package tn.TAKWIRAProject.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class competition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
    private String nom;
    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private terrain terrain;

	public competition() {
	}

	public competition(Long id, String nom, String description, LocalDateTime dateDebut, LocalDateTime dateFin,
			tn.TAKWIRAProject.entities.terrain terrain) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.terrain = terrain;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(terrain terrain) {
		this.terrain = terrain;
	}
    
    
}
