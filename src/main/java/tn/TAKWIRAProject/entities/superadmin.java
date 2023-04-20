package tn.TAKWIRAProject.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="superadmin")
public class superadmin extends utilisateur {
	public superadmin() {
	}
	public superadmin(Long idClient, String nom, String prenom, String nomUtilisateur, String motDePasse,
			String confirmationMotDePasse, String email, String phone, String adresse, String pays) {
		super(idClient, nom, prenom, nomUtilisateur, motDePasse, confirmationMotDePasse, email, phone, adresse, pays);
	}
}