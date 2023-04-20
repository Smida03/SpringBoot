package tn.TAKWIRAProject.services;

import tn.TAKWIRAProject.entities.demandereservation;

public interface INotificationService {
	    void envoyerNotificationDemandeValidee(demandereservation demande);
	    
	    void envoyerNotificationDemandeAnnulee(demandereservation demande);
	    
	    void envoyerNotificationErreurPaiement(demandereservation demande);
}
