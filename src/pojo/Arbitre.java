package pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "arbitre")
public class Arbitre {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idArbitre", unique = true, nullable = false)
	private Integer idArbitre ;
	@Column(name="Licence",nullable = false,length = 4,unique = true)
	private int Licence;
	@Column(name = "Nom",nullable = false,length = 50)
	private String Nom ;
	@Column(name = "Prenom",nullable = false, length = 50)
	private String Prenom ;  
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "arbitre")
	private Set<Matchs> matchs = new HashSet<Matchs>(0);
	
	public Arbitre(){
	}
	public Arbitre(int Licence,String Nom,String Prenom){
		this.Licence = Licence;
		this.Nom = Nom;
		this.Prenom = Prenom;
	}
	public Arbitre(int Licence, String Nom,String Prenom,Set<Matchs> matchs ){
		this.Licence = Licence;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.matchs = matchs;
	}
	
	//Getters /Setters
	public Integer getIdArbitre() {
		return this.idArbitre;
	}
	public void setIdArbitre(Integer idArbitre) {
		this.idArbitre = idArbitre;
	}
	
	public String getNom() {
		return this.Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	
	public String getPrenom() {
		return this.Prenom;
	}
	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}
	
	public Set<Matchs> getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Set<Matchs> matchs) {
		this.matchs = matchs;
	}
	public int getLicence() {
		return this.Licence;
	}
	public void setLicence(int licence) {
		this.Licence = licence;
	}

  

}
