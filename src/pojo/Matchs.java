package pojo;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "matchs")
public class Matchs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMatch",nullable = false,length = 4)
	private Integer idMatch;
	@Column(name = "NumeroDeMatch",nullable = false,unique = true,length = 4)
	private int NumeroDeMatch ;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date",nullable = false,length = 15)
	private Date date ;
	@Column(name = "Heure",nullable = false,length = 5)
	private String Heure ;
	@Column(name = "Score",nullable = true,length = 4)
	private String Score ;
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "dispute",joinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idClub",nullable = false,updatable = false)
	  })
	private Set<Clubs> clubs = new HashSet<Clubs>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "se_deroule",joinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idLieux",nullable = false,updatable = false)
	  })
	private Set<Lieux> lieux =  new HashSet<Lieux>(0);
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idArbitre",nullable = false)
	private Arbitre arbitre;
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "joue",catalog = "argentinos-ll",joinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idEquipe",nullable = false,updatable = false)
	  })
	private Set<Equipes> equipes = new HashSet<Equipes>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "participe",catalog = "argentinos-ll",joinColumns ={
			  @JoinColumn(name = "idMatch",nullable = false,updatable = false) },inverseJoinColumns ={
			  @JoinColumn(name = "idJoueurs",nullable = false,updatable = false)
	  })
	private Set<Joueurs> joueurs = new HashSet<Joueurs>(0);
	@OneToMany(fetch = FetchType.LAZY,mappedBy ="matchs")
	private Set<Blessures> blessures = new HashSet<Blessures>(0);
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "matchs")
	private Set<Suspensions> suspensions = new HashSet<Suspensions>(0);
	
	public Matchs(){	
	}

	public Matchs(int NumeroDeMatch,Date date, String Heure, String Score,Arbitre arbitre){
		this.NumeroDeMatch = NumeroDeMatch;
		this.date = date;
		this.Heure = Heure;
		this.Score = Score;
		this.arbitre = arbitre;
		
	}
	public Matchs(int NumeroDeMatch,Date date, String Heure, String Score,Set<Clubs> clubs ,Set<Lieux> lieux,Set<Equipes> equipes,
			Set<Joueurs> joueurs,Set<Blessures> blessures,Set<Suspensions> suspensions,Arbitre arbitre){
		this.NumeroDeMatch = NumeroDeMatch;
		this.date = date;
		this.Heure = Heure;
		this.Score = Score;
		this.clubs = clubs;
		this.lieux = lieux;
		this.equipes = equipes;
		this.joueurs = joueurs;
		this.blessures = blessures;
		this.suspensions = suspensions;
		this.arbitre = arbitre;
	}
	  
	//Getters/Setters
	public int getNumeroDeMatch() {
		return this.NumeroDeMatch;
	}
	public void setNumeroDeMatch(int numeroDeMatch) {
		this.NumeroDeMatch = numeroDeMatch;
	}
	
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHeure() {
		return this.Heure;
	}
	public void setHeure(String heure) {
		this.Heure = heure;
	}
	
	public String getScore() {
		return this.Score;
	}
	public void setScore(String score) {
		this.Score = score;
	}
	
	public Set<Clubs> getClubs() {
		return this.clubs;
	}
	public void setClubs(Set<Clubs> clubs) {
		this.clubs = clubs;
	}
	
	public Set<Lieux> getLieux() {
		return this.lieux;
	}
	public void setLieux(Set<Lieux> lieux) {
		this.lieux = lieux;
	}
	
	public Arbitre getArbitre() {
		return this.arbitre;
	}
	public void setArbitre(Arbitre Arbitre) {
		this.arbitre = Arbitre;
	}
	
	public Set<Equipes> getEquipes() {
		return this.equipes;
	}
	public void setEquipes(Set<Equipes> equipes) {
		this.equipes = equipes;
	}
	
	public Set<Joueurs> getJoueurs() {
		return this.joueurs;
	}
	public void setJoueurs(Set<Joueurs> joueurs) {
		this.joueurs = joueurs;
	}
	
	public Set<Blessures> getBlessures() {
		return this.blessures;
	}
	public void setBlessures(Set<Blessures> blessures) {
		this.blessures = blessures;
	}
	
	public Set<Suspensions> getSuspensions() {
		return this.suspensions;
	}
	public void setSuspensions(Set<Suspensions> suspensions) {
		this.suspensions = suspensions;
	}
	public Integer getIdMatch() {
		return this.idMatch;
	}
	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

  

}
