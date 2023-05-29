package gestionSalle.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="salle")
public class Salle {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="codeSalle")
	private long codeSalle;
	
	@Column(name="designationSalle")
	private String designationSalle;
	
	@OneToMany(mappedBy= "salleOccupe")
	private Set<Occuper> occupe= new HashSet<>();
	
	public Salle(String designationSalle) {
		super();
		this.designationSalle = designationSalle;
	}
	
	public Set<Occuper> getOccupe() {
		return occupe;
	}

	public void setOccupe(Set<Occuper> occupe) {
		this.occupe = occupe;
	}

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salle(long codeSalle, String designationSalle) {
		super();
		this.codeSalle = codeSalle;
		this.designationSalle = designationSalle;
	}
	public long getCodeSalle() {
		return codeSalle;
	}
	public void setCodeSalle(long codeSalle) {
		this.codeSalle = codeSalle;
	}
	public String getDesignationSalle() {
		return designationSalle;
	}
	public void setDesignationSalle(String designationSalle) {
		this.designationSalle = designationSalle;
	}
	

}
