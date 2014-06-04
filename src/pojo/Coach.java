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
import javax.persistence.Table;

@Entity
@Table(name = "coach")
public class Coach {
	
	 @Id
	 @GeneratedValue(strategy = IDENTITY)
	 @Column(name = "idCoach",nullable = false, length = 4)
	  private Integer idCoach ;
	 @Column(name = "Nom",nullable = false,length = 50)
	  private String Nom ;
	 @Column(name = "Prenom",nullable = false,length = 50)
	  private String Prenom ;
	 @Column(name = "AnneeDActivites",nullable = false,length = 15)
	  private String AnneeDActivites ;
	 @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "equipecoachs",joinColumns ={
			  @JoinColumn(name = "idCoach",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false)
	  })
	  private Set<Equipes> equipes = new HashSet<Equipes>(0);
	  
	 
	  public Coach(){
	  }
	  public Coach(String Nom,String Prenom,String AnneeDActivites){
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.AnneeDActivites = AnneeDActivites;
	  }
	  public Coach(String Nom,String Prenom,String AnneeDActivites,Set<Equipes> equipes){
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.AnneeDActivites = AnneeDActivites;
		  this.equipes = equipes;
	  }
	
	  
	 //Getters/Setters
	 public Integer getIdCoach() {
		return this.idCoach;
	}
	public void setIdCoach(Integer idCoach) {
		this.idCoach = idCoach;
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
	
	public String getAnneeDActivites() {
		return this.AnneeDActivites;
	}
	public void setAnneeDActivites(String anneeDActivites) {
		this.AnneeDActivites = anneeDActivites;
	}
	
	public Set<Equipes> getEquipes() {
		return this.equipes;
	}
	public void setEquipes(Set<Equipes> equipes) {
		this.equipes = equipes;
	}
	
  
  

}
