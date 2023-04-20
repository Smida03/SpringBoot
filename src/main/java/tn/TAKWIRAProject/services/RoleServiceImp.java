package tn.TAKWIRAProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.role;
import tn.TAKWIRAProject.repository.RoleRepository;
@Service
public class RoleServiceImp implements IRoleService {

	@Autowired
	RoleRepository RoleRep;
	
	@Override
	public role addrole(role role) {
		
		return RoleRep.save(role);
	}

}
