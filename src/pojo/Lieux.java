package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Lieux")
public class Lieux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLieux",nullable = false,length = 2)
	private Integer idLieux;
	@Column(name = "Adresse",nullable = false,length = 100)
	private String Adresse ;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lieux")
	private Set<Matchs> matchs = new HashSet<Matchs>(0);
	
	public Lieux(){	
	}
	public Lieux(String Adresse){	
		this.Adresse = Adresse;
	}
	public Lieux(String Adresse, Set<Matchs> matchs){	
		this.Adresse = Adresse;
		this.matchs = matchs;
	}
	
	//Getters/Setters
  public Integer getIdLieux() {
		return this.idLieux;
	}
	public void setIdLieux(Integer idLieux) {
		this.idLieux = idLieux;
	}
	
	public String getAdresse() {
		return this.Adresse;
	}
	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}
	
	public Set<Matchs> getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Set<Matchs> matchs) {
		this.matchs = matchs;
	}


}
