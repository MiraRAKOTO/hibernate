package gestionSalle.model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="occuper")
public class Occuper {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "codeOccupe") 
	private long codeOccupe;
	
	@ManyToOne
	@JoinColumn(name= "occupeCodeProf")
	private Prof profOccupe;
	
	@ManyToOne
	@JoinColumn(name="occupeCodeSalle")
	private Salle salleOccupe;
	
	@Temporal(value= TemporalType.DATE) 
	@Column(name="date")
	private Date date;
	
	@Temporal(value= TemporalType.TIME) 
	@Column(name="timedeb")
	private Date timedeb;
	
	@Temporal(value= TemporalType.TIME) 
	@Column(name="timefin")
	private Date timefin;
	
	

	public Occuper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occuper(long codeOccupe, Prof profOccupe, Salle salleOccupe, Date date, Date timedeb, Date timefin) {
		super();
		this.codeOccupe = codeOccupe;
		this.profOccupe = profOccupe;
		this.salleOccupe = salleOccupe;
		this.date = date;
		this.timedeb = timedeb;
		this.timefin = timefin;
	}

	public long getCodeOccupe() {
		return codeOccupe;
	}

	public void setCodeOccupe(long codeOccupe) {
		this.codeOccupe = codeOccupe;
	}

	public Prof getProfOccupe() {
		return profOccupe;
	}

	public void setProfOccupe(Prof profOccupe) {
		this.profOccupe = profOccupe;
	}

	public Salle getSalleOccupe() {
		return salleOccupe;
	}

	public void setSalleOccupe(Salle salleOccupe) {
		this.salleOccupe = salleOccupe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTimedeb() {
		return timedeb;
	}

	public void setTimedeb(Date timedeb) {
		this.timedeb = timedeb;
	}

	public Date getTimefin() {
		return timefin;
	}

	public void setTimefin(Date timefin) {
		this.timefin = timefin;
	}
	
	
	
	
	
}
