package tn.TAKWIRAProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.adminmarketing;
import tn.TAKWIRAProject.entities.role;
import tn.TAKWIRAProject.repository.AdminMarketingRepository;
import tn.TAKWIRAProject.repository.RoleRepository;

@Service
public class AdminMarketingService implements  IAdminMarketingService {
	@Autowired
	 private AdminMarketingRepository adminmarketingRepository;
	@Autowired
	private RoleRepository roleRep;
	
	
   public List<adminmarketing> getAllAdminMarketing() {
       return adminmarketingRepository.findAll();
   }

   
   public adminmarketing getAdminMarketingById(Long id) {
       return adminmarketingRepository.findById(id).orElse(null);
   }

   
   public adminmarketing addAdminMarketing(adminmarketing AdminMarketing) {
       return adminmarketingRepository.save(AdminMarketing);
   }
   public adminmarketing updateAdminMarketing(adminmarketing AdminMarketing) {
       return adminmarketingRepository.save(AdminMarketing);
   }

   
   public void deleteAdminMarketing(Long id) {
	   adminmarketingRepository.deleteById(id);
   }
   
   public adminmarketing addAdminMarketingRole(Long id, Long idRole) {
	   adminmarketing adminmarketing= adminmarketingRepository.findById(id).get();
	   role role= roleRep.findById(idRole).get();
	   adminmarketing.addrole(role);
	   return adminmarketingRepository.save(adminmarketing);
   }
}
