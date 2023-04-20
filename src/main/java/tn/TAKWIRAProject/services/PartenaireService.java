package tn.TAKWIRAProject.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.TAKWIRAProject.entities.partenaire;
import tn.TAKWIRAProject.entities.role;
import tn.TAKWIRAProject.repository.PartenaireRepository;
import tn.TAKWIRAProject.repository.RoleRepository;

@Service
public class PartenaireService implements IPartenaireService {
	
	@Autowired
	 private PartenaireRepository partenaireRepository;
	
	@Autowired
    private RoleRepository roleRep;
	
    public List<partenaire> getAllPartenaires() {
        return partenaireRepository.findAll();
    }

    
    public partenaire getPartenaireById(Long id) {
        return partenaireRepository.findById(id).orElse(null);
    }

    
    public partenaire addPartenaire(partenaire Partenaire) {
        return partenaireRepository.save(Partenaire);
    }

    
    public partenaire updatePartenaire(partenaire Partenaire) {
        return partenaireRepository.save(Partenaire);
    }

    
    public void deletePartenaire(Long id) {
    	partenaireRepository.deleteById(id);
    }
	
    public partenaire addutilisateurRole(Long id, Long idRole) {
  	   partenaire partenaire= partenaireRepository.findById(id).get();
  	   role role= roleRep.findById(idRole).get();
  	   partenaire.addrole(role);
  	   return partenaireRepository.save(partenaire);
     }

}
