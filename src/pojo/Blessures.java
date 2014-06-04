package pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "blessures")
public class Blessures {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idBles",nullable = false,length = 2)
	 private Integer idBles ;
	 @Column(name = "NumeroDAffiliation",nullable = false,length = 6)
	 private int NumeroDAffiliation ;
	 @Column(name = "Blessure",nullable = false, length = 50)
	 private char Blessures  ;
	 @Temporal(TemporalType.DATE)
	 @Column(name = "Duree",nullable = false, length = 15)
	 private Date Duree ;
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "idMatch",nullable = false) 
	 private Matchs matchs;//<Matchs>
	  
	  public Blessures(){
		 }
	  public Blessures(int NumeroDAffiliation, char Blessures, Date Duree){
		  this.NumeroDAffiliation = NumeroDAffiliation;
		  this.Blessures = Blessures;
		  this.Duree = Duree;
		 }
	  public Blessures(int NumeroDAffiliation, char Blessures, Date Duree, Matchs matchs){
		  this.NumeroDAffiliation = NumeroDAffiliation;
		  this.Blessures = Blessures;
		  this.Duree = Duree;
		  this.matchs = matchs;
		 }
	  
	 //Getters /Setters
	public Integer getIdBles() {
		return this.idBles;
	}
	public void setIdBles(Integer idBles) {
		this.idBles = idBles;
	}
	 public int getNumeroDAffiliation() {
		return this.NumeroDAffiliation;
	}
	public void setNumeroDAffiliation(int numeroDAffiliation) {
		this.NumeroDAffiliation = numeroDAffiliation;
	}
	
	public char getBlessures() {
		return this.Blessures;
	}
	public void setBlessures(char blessures) {
		this.Blessures = blessures;
	}
	public Date getDuree() {
		return this.Duree;
	}
	public void setDuree(Date duree) {
		this.Duree = duree;
	}
	
	public Matchs getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}

  
  

}
