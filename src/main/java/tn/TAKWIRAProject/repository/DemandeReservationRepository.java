package tn.TAKWIRAProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.TAKWIRAProject.entities.demandereservation;



@Repository
public interface DemandeReservationRepository extends JpaRepository<demandereservation, Long> {
	List<demandereservation> findByStatut(String statut);

	List<demandereservation> findByClientId(Long id);
}
