package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.adminmarketing;

public interface IAdminMarketingService {
	public List<adminmarketing> getAllAdminMarketing();
	public adminmarketing getAdminMarketingById(Long id);
	public adminmarketing addAdminMarketing(adminmarketing AdminMarketing);
	public adminmarketing updateAdminMarketing(adminmarketing AdminMarketing);
	public void deleteAdminMarketing(Long id);
	public adminmarketing addAdminMarketingRole(Long id, Long idRole);

}
