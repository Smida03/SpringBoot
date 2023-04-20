package tn.TAKWIRAProject.services;

import java.util.List;


import tn.TAKWIRAProject.entities.superadmin;

public interface ISuperAdminService {
	public List<superadmin> getAllSuperAdmins();
	public superadmin getSuperAdminById(Long id);
	public superadmin addSuperAdmin(superadmin superadmin);
	public superadmin updateSuperAdmin(superadmin superadmin);
	public void deleteSuperAdmin(Long id);

}
