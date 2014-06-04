package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "joueurs")
public class Joueurs {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "idJoueurs",nullable = false,length = 3)
	  private Integer idJoueurs  ;
	  @Column(name="NumeroDAffiliation",nullable = false,length = 6,unique = true)
	  private int NumeroDAffiliation;
	  @Column(name = "Nom",nullable = false,length =50)
	  private String Nom ;
	  @Column(name = "Prenom",nullable = false,length = 50)
	  private String Prenom ;
	  @Temporal(TemporalType.DATE)
	  @Column(name = "DateDeNaissance",nullable = false,length = 15)
	  private Date DateDeNaissance ;
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "joueursmontants",joinColumns ={
			  @JoinColumn(name = "idJoueurs",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false)
	  })
	  private Set<Equipes> equipes = new HashSet<Equipes>(0);
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "joueurmatch",joinColumns ={
			  @JoinColumn(name = "idJoueurs",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false)
	  })
	  private Set<Matchs> matchs = new HashSet<Matchs>(0);
	  
	  public Joueurs(){  
	  }
	  public Joueurs(int NumeroDAffiliation, String Nom,String Prenom,Date DateDeNaissance){ 
		  this.NumeroDAffiliation = NumeroDAffiliation;
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.DateDeNaissance = DateDeNaissance;	  
	  }
	  public Joueurs(int NumeroDAffiliation, String Nom,String Prenom,Date DateDeNaissance,Set<Equipes> equipes,Set<Matchs> matchs){
		  this.NumeroDAffiliation = NumeroDAffiliation;
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.DateDeNaissance = DateDeNaissance;	 
		  this.equipes = equipes;
		  this.matchs = matchs;
	  }
	
	  //Getters/Setters
	public Integer getIdJoueurs() {
			return this.idJoueurs;
		}
	
	public void setIdJoueurs(Integer idJoueurs) {
			this.idJoueurs = idJoueurs;
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
	
	public Date getDateDeNaissance() {
		return this.DateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.DateDeNaissance = dateDeNaissance;
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
	public int getNumeroDAffiliation() {
		return this.NumeroDAffiliation;
	}
	public void setNumeroDAffiliation(int numeroDAffiliation) {
		NumeroDAffiliation = numeroDAffiliation;
	}

  
  
  

}
