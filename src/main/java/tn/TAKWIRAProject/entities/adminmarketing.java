package tn.TAKWIRAProject.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name="adminmarketing")
public class adminmarketing extends utilisateur{
	@JsonIgnore
	@OneToMany(mappedBy = "adminm")
	private List<publicite> publicites;

	public adminmarketing() {
		super();
	}
	
}
