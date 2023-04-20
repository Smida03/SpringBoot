package tn.TAKWIRAProject.entities;

import java.io.IOException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String nomDeTerrain;
	private String description;
	@Lob
	private byte[] image;
	private String localisation;
	@ManyToOne
	@JoinColumn(name = "partenaire_id")
	private partenaire partenaire;

	public terrain() {

	}

	public terrain(Long id, String nomDeTerrain, String description, byte[] image, String localisation) {
		super();
		this.id = id;
		this.nomDeTerrain = nomDeTerrain;
		this.description = description;
		this.image = image;
		this.localisation = localisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomDeTerrain() {
		return nomDeTerrain;
	}

	public void setNomDeTerrain(String nomDeTerrain) {
		this.nomDeTerrain = nomDeTerrain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(partenaire partenaire) {
		this.partenaire = partenaire;
	}

	public void saveImage(MultipartFile imageFile) throws IOException {
		this.image = imageFile.getBytes();
	}

	public void deleteImage() {
		this.image = null;
	}
}
