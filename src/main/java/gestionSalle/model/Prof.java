package gestionSalle.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="prof")

public class Prof {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	@Column(name="codeProf")
	private long codeProf;
	
	@Column(name="nomProf")
	private String nomProf;
	
	@Column(name="prenomProf")
	private String prenomProf;
	
	@Column(name="grade")
	private String grade;
	
	@OneToMany(mappedBy= "profOccupe")
	private Set<Occuper> occuper= new HashSet<>();
	
	
	
	public Prof() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Prof(String nomProf, String prenomProf, String grade) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.grade = grade;
	}

	public Prof(long codeProf, String nomProf, String prenomProf, String grade) {
		super();
		this.codeProf = codeProf;
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.grade = grade;
	}
	
	public Set<Occuper> getOccuper() {
		return occuper;
	}

	public void setOccuper(Set<Occuper> occuper) {
		this.occuper = occuper;
	}

	public long getCodeProf() {
		return codeProf;
	}
	public void setCodeProf(long codeProf) {
		this.codeProf = codeProf;
	}
	public String getNomProf() {
		return nomProf;
	}
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}
	public String getPrenomProf() {
		return prenomProf;
	}
	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
