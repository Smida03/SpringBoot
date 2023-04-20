package tn.TAKWIRAProject.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    @ManyToMany(mappedBy = "listRole")
    private List<utilisateur> listuser = new ArrayList<>();
	public role() {
	}
	public role(Long idRole,RoleName roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	public List<utilisateur> getListuser() {
		return listuser;
	}
	public void setListuser(List<utilisateur> listuser) {
		this.listuser = listuser;
	}
	
}