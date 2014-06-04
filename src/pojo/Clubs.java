package pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "clubs")
public class Clubs {
	
	 
	  @Id
	  @GeneratedValue(strategy = IDENTITY)
	  @Column(name = "idClub",nullable = false,length = 2)
	  private Integer idClub;
	  @Column(name = "Matricule", nullable = false, length = 4,unique = true)
	  private int Matricule ;
	  @Column(name = "Nom", nullable = false, length = 50)
	  private String Nom ;
	   @OneToMany(fetch = FetchType.LAZY, mappedBy = "clubs")
	  private Set<Equipes> equipes = new HashSet<Equipes>(0);
	   @ManyToMany(fetch = FetchType.LAZY)
		  @JoinTable(name = "clubmatch",joinColumns ={
				  @JoinColumn(name = "idClub",nullable = false,updatable = false) },inverseJoinColumns ={
				  @JoinColumn(name = "idMatch",nullable = false,updatable = false)
		  })
	  private Set<Matchs> matchs = new HashSet<Matchs>(0);
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "idPres",nullable = false)
	  private President president;
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "idCq",nullable = false)
	  private CorrespondantQualifie correspondantqualifie;
	 
	  
	  public Clubs(){
	  }
	  public Clubs(int Matricule,String Nom,President president,CorrespondantQualifie correspondantqualifie){
		  this.Matricule = Matricule;
		  this.Nom = Nom;
		  this.president = president;
		  this.correspondantqualifie = correspondantqualifie;
	  }
	  public Clubs(int Matricule,String Nom,Set<Equipes> equipes,Set<Matchs> matchs,President president,CorrespondantQualifie correspondantqualifie ){
		  this.Matricule = Matricule;
		  this.Nom = Nom;
		  this.equipes = equipes;
		  this.matchs = matchs;
		  this.president = president;
		  this.correspondantqualifie = correspondantqualifie;
		  
	  }

	//Getters/Setters
	public String getNom() {
	  return this.Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	
	public int getMatricule() {
		return this.Matricule;
	}
	
	public void setMatricule(int matricule) {
		this.Matricule = matricule;
	}
	
	public Set<Equipes> getEquipes() {
		return this.equipes;
	}
	public void setEquipes(Set<Equipes> equipes) {
		this.equipes = equipes;
	}
	
	public Set<Matchs> getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Set<Matchs> matchs) {
		this.matchs = matchs;
	}
	 public President getPresident() {
			return this.president;
		}
    public void setPresident(President president) {
			this.president = president;
		}
	public CorrespondantQualifie getCorrespondantqualifie() {
			return this.correspondantqualifie;
		}
	public void setCorrespondantqualifie(CorrespondantQualifie correspondantqualifie) {
			this.correspondantqualifie = correspondantqualifie;
		}
	 public Integer getIdClub() {
			return this.idClub;
		}
		public void setIdClub(Integer idClub) {
			this.idClub = idClub;
		}

  

}
