package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correspondantQualifie")
public class CorrespondantQualifie {
	
	  
	 
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "idCq",nullable = false,length = 2)  
	  private Integer idCq ;
	  @Column(name = "Nom",nullable = false, length = 50)
	  private String Nom ;
	  @Column(name = "Prenom",nullable = false,length = 50)
	  private String Prenom ;
	  @Column(name = "Telephone",nullable = false,length = 15)
	  private String Telephone ;
	  @Column(name = "e_mail",nullable = false,length = 100)
	  private String e_mail ;
	  @OneToOne(fetch = FetchType.LAZY,mappedBy = "correspondantqualifie")
	  private Clubs club;
	  
	  public CorrespondantQualifie(){
	  }
	  public CorrespondantQualifie(String Nom,String Prenom,String Telephone,String e_mail){
		  this.Nom = Nom;
		  this.Prenom = Prenom;
		  this.Telephone = Telephone;
		  this.e_mail = e_mail;
	  }
	  
	
	 //Getters/Setters
	public Integer getIdCq() {
			return idCq;
		}
	  public void setIdCq(Integer idCq) {
			this.idCq = idCq;
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
	
	 public String getE_mail() {
			return this.e_mail;
		}
	public void setE_mail(String e_mail) {
			this.e_mail = e_mail;
		}
	public Clubs getClub() {
			return this.club;
		}
	public void setClub(Clubs club) {
			this.club = club;
		}

  

}
