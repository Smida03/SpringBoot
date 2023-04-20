package tn.TAKWIRAProject.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="client")
public class client extends utilisateur {

	public client() {	  
	}
	public client(Long id, String nom, String prenom, String nomUtilisateur, String motDePasse,
	    String confirmationMotDePasse, String email, String phone, String adresse, String pays ) {
	    super(id, nom, prenom, nomUtilisateur, motDePasse, confirmationMotDePasse, email, phone, adresse, pays);
	} 
}
