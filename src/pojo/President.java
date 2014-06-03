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
@Table(name = "president")
public class President{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPres",nullable = false,length = 2)
	private Integer idPres ;
	@Column(name = "Nom",nullable = false,length = 50)
	private String Nom ;
	@Column(name = "Prenom",nullable = false,length = 50)
	private String Prenom ;
	@Column(name = "AnneesDActivite",nullable = false,length = 15)
	private String AnneesDActivite ;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "president")
    private Clubs clubs; 
	
	public President(){
	}
	public President(String Nom,String Prenom,String AnneesDActivites){
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.AnneesDActivite = AnneesDActivites;
	}
	
	
	public Integer getIdPres() {
		return this.idPres;
	}
	public void setIdPres(Integer idPres) {
		this.idPres = idPres;
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
	
	public String getAnneesDActivite() {
		return this.AnneesDActivite;
	}
	public void setAnneesDActivite(String anneesDActivite) {
		AnneesDActivite = anneesDActivite;
	}
	public Clubs getClubs() {
		return this.clubs;
	}
	public void setClubs(Clubs clubs) {
		this.clubs = clubs;
	}

	@Override
	public String toString() {
		return "President [idPres=" + idPres + ", Nom=" + Nom + ", Prenom="
				+ Prenom + ", AnneesDActivite=" + AnneesDActivite + ", clubs="
				+ clubs + "]";
	}


}
