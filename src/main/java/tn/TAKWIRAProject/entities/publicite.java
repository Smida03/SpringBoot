package tn.TAKWIRAProject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "adminm")
@Entity
@Table(name = "publicite")
public class publicite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpub;
	
	private String titre;
	
	private String description;
	
	private String imageUrl;
	
	private String statut;
	
	@ManyToOne
	@JoinColumn(name = "adminm_id")
	private adminmarketing adminm;

}