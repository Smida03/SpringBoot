package tn.TAKWIRAProject.services;

import org.springframework.stereotype.Service;


import tn.TAKWIRAProject.entities.demandereservation;

@Service

public class NotificationService implements INotificationService {
	
	@Override
	public void envoyerNotificationDemandeValidee(demandereservation demande) {  
	}

	@Override
	public void envoyerNotificationDemandeAnnulee(demandereservation demande) {
	}
	
	@Override
	public void envoyerNotificationErreurPaiement(demandereservation demande) {  
	}
		
}
