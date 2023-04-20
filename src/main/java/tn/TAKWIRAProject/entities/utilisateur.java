package tn.TAKWIRAProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class utilisateur{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String nomUtilisateur;
	private String motDePasse;
	private String confirmationMotDePasse;
	private String email;
	private String phone;
	private String adresse;
	private String pays;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="UserRole",joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="idRole"))
	private List<role> listRole = new ArrayList<>();
	public utilisateur() {
		
	}
		public utilisateur(Long id, String nom, String prenom, String nomUtilisateur, String motDePasse,
			String confirmationMotDePasse, String email, String phone, String adresse, String pays ) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.confirmationMotDePasse = confirmationMotDePasse;
		this.email = email;
		this.phone = phone;
		this.adresse = adresse;
		this.pays = pays;
		
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	public List<role> getListRole() {
		return listRole;
	}
	public void setListRole(List<role> listRole) {
		this.listRole = listRole;
	}
	public void addrole(role role) {
		this.listRole.add(role);
	}
	
}
