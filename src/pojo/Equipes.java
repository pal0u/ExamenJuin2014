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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipes")
public class Equipes {
	
	 
	  @Id
      @GeneratedValue(strategy = IDENTITY)
      @Column(name = "idEquipe",nullable = false,length = 2)
	  private Integer idEquipe ;
	  @Column(name = "Serie",nullable = false,length = 50)
	  private String Serie ;
	  @Column(name = "Annee",nullable = false,length = 4)
	  private int Annee;
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "equipematch",joinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false)
	  })
	  private Set<Matchs> matchs = new HashSet<Matchs>(0);
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "joueursmontants",joinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idJoueurs",nullable = false,updatable = false)
	  })
	  private Set<Joueurs> joueurs = new HashSet<Joueurs>(0);
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "equipedelegue",joinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idDelegue",nullable = false,updatable = false)
	  })
	  private Set<Delegue> delegue = new HashSet<Delegue>(0);
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "equipecoachs",joinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idCoach",nullable = false,updatable = false)
	  })
	  private Set<Coach> coach = new HashSet<Coach>(0);
	  @OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "idClub",nullable = false)
	  private Clubs clubs;
	  
	  public Equipes(){
	  }
	  
	  public Equipes(String Serie,int Annee){
		  this.Serie = Serie;
		  this.Annee = Annee;
	  }
	  
	  public Equipes(String Serie,int Annee,Set<Matchs> matchs,Set<Joueurs> joueurs,Set<Delegue> delegue,Set<Coach> coach){
		  this.Serie = Serie;
		  this.Annee = Annee;
		  this.matchs = matchs;
		  this.joueurs = joueurs;
		  this.delegue = delegue;
		  this.coach = coach;
	  }
	  
	//Getters/Setters
    
    public Integer getIdEquipe() {
		return this.idEquipe;
	}
	public void setIdEquipe(Integer idEquipe) {
		this.idEquipe = idEquipe;
	}
	
	public String getSerie() {
		return this.Serie;
	}
	public void setSerie(String serie) {
		this.Serie = serie;
	}
	
	public int getAnnee() {
		return this.Annee;
	}
	public void setAnnee(int annee) {
		this.Annee = annee;
	}
	
	public Set<Matchs> getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Set<Matchs> matchs) {
		this.matchs = matchs;
	}
	
	public Set<Joueurs> getJoueurs() {
		return this.joueurs;
	}
	public void setJoueurs(Set<Joueurs> joueurs) {
		this.joueurs = joueurs;
	}
	
	public Set<Delegue> getDelegue() {
		return this.delegue;
	}
	public void setDelegue(Set<Delegue> delegue) {
		this.delegue = delegue;
	}
	
	public Set<Coach> getCoach() {
		return this.coach;
	}
	public void setCoach(Set<Coach> coach) {
		this.coach = coach;
	}
	
    public Clubs getClubs() {
			return this.clubs;
		}
	public void setClubs(Clubs clubs) {
			this.clubs = clubs;
		}
	
    

  
  
}
