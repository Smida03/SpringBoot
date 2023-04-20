package tn.TAKWIRAProject.services;

import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.demandereservation;

@Service
public class PaiementService {
	    
	    public boolean payer(demandereservation demandeReservation) {
	        // Comparer le montant demandé avec le prix de réservation
	        double prixReservation = 20; // Récupérer le prix de réservation depuis la base de données ou une autre source de données
	        double montantDemande = 20; // Récupérer le montant demandé depuis la demande de réservation
	        
	        if (montantDemande == prixReservation) {
	            // Votre logique de paiement ici
	            // Si le paiement est réussi, retourner true, sinon retourner false
	            return true;
	        } else {
	            return false;
	        }
	    }
	}

