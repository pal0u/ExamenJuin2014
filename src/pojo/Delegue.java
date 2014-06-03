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
@Table(name = "delegue")
public class Delegue {
	
	  @Id  
	  @GeneratedValue(strategy = IDENTITY)
	  @Column(name = "idDelegue",nullable = false,length = 4)
	  private Integer idDelegue;
	  @Column(name = "Nom",nullable = false,length = 50)
	  private String Nom ;
	  @Column(name = "Prenom",nullable = false,length = 50)
	  private String Prenom ;
	  @Column(name = "Telephone", nullable = false, length = 15)
	  private String Telephone ;
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "comporte",joinColumns ={
			  @JoinColumn(name = "idDelegue",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false)
	  })
	  private Set<Equipes> equipes = new HashSet<Equipes>(0);
	  
	  public Delegue(){
	  }
	  public Delegue(String Nom,String Prenom,String Telephone){
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.Telephone = Telephone;
	  }
	  public Delegue(String Nom,String Prenom,String Telephone,Set<Equipes> equipes){
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.Telephone = Telephone;
		  this.equipes = equipes;
	  }
	  
	//Getters/Setters
    public Integer getIdDelegue() {
		return this.idDelegue;
	}
	public void setIdDelegue(Integer idDelegue) {
		this.idDelegue = idDelegue;
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
	
	public String getTelephone() {
		return this.Telephone;
	}
	public void setTelephone(String telephone) {
		this.Telephone = telephone;
	}
	
	public Set<Equipes> getEquipes() {
		return this.equipes;
	}
	public void setEquipes(Set<Equipes> equipes) {
		this.equipes = equipes;
	}


}
