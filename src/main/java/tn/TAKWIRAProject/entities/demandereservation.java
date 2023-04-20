package tn.TAKWIRAProject.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class demandereservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	
private Long id;

private LocalDate date;

private LocalTime heureDebut;

private LocalTime heureFin;
private String statut="En Attente";
private String statutRemboursement="Remboursable";


@ManyToOne
@JoinColumn(name = "clientId")
private client client;

@ManyToOne
@JoinColumn(name = "terrainId")
private terrain terrain;


public demandereservation() {
}


public demandereservation(Long id, LocalDate date, LocalTime heureDebut, LocalTime heureFin, String statut,
		String statutRemboursement, tn.TAKWIRAProject.entities.client client) {
	super();
	this.id = id;
	this.date = date;
	this.heureDebut = heureDebut;
	this.heureFin = heureFin;
	this.statut = statut;
	this.statutRemboursement = statutRemboursement;
	this.client = client;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public LocalTime getHeureDebut() {
	return heureDebut;
}
public void setHeureDebut(LocalTime heureDebut) {
	this.heureDebut = heureDebut;
}
public LocalTime getHeureFin() {
	return heureFin;
}
public void setHeureFin(LocalTime heureFin) {
	this.heureFin = heureFin;
}
public String getStatut() {
	return statut;
}
public void setStatut(String statut) {
	this.statut = statut;
}
public String getStatutRemboursement() {
	return statutRemboursement;
}
public void setStatutRemboursement(String statutRemboursement) {
	this.statutRemboursement = statutRemboursement;
}
public client getClient() {
	return client;
}
public void setClient(client client) {
	this.client = client;
}


}