package tn.TAKWIRAProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.TAKWIRAProject.entities.role;
import tn.TAKWIRAProject.services.RoleServiceImp;

@RestController
public class RoleController {

	@Autowired
	RoleServiceImp RoleServ;
	
	@PostMapping(value="/addrole")
	public role addrole(@RequestBody role role) {
		return RoleServ.addrole(role);
		
	}
}
