package tn.TAKWIRAProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.TAKWIRAProject.entities.adminmarketing;
import tn.TAKWIRAProject.entities.publicite;

public interface PubliciteRepository extends JpaRepository<publicite, Long> {

	  List<publicite> findByAdminm(adminmarketing adminm);
	    
	    Optional<publicite> findByAdminmAndIdpub(adminmarketing adminm, Long idpub);
}
