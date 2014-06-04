package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "suspensions")
public class Suspensions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSus",nullable = false,length = 2)
	private Integer idSus;
	@Column(name = "NumeroDAffiliation",nullable = false,length = 6)
	private int NumeroDAffiliation ;
	@Column(name = "Nombre",nullable = false,length = 4)
	private String Nombre ;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMatch",nullable = false)
	private Matchs matchs;
	
	public Suspensions(){
	}
	public Suspensions(int NumeroDAffiliation, String nombre){
		this.NumeroDAffiliation = NumeroDAffiliation;
		this.Nombre = nombre;
	}
	public Suspensions(int NumeroDAffiliation, String nombre, Matchs matchs){
		this.NumeroDAffiliation = NumeroDAffiliation;
		this.Nombre = nombre;
		this.matchs = matchs;
	}
	
	//Getters/Setters
	public Integer getIdSus() {
		return this.idSus;
	}
	public void setIdSus(Integer idSus) {
		this.idSus = idSus;
	}
	
	public int getNumeroDAffiliation() {
		return this.NumeroDAffiliation;
	}
	public void setNumeroDAffiliation(int numeroDAffiliation) {
		this.NumeroDAffiliation = numeroDAffiliation;
	}
	
	public String getNombre() {
		return this.Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	
	public Matchs getMatchs() {
		return this.matchs;
	}
	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}

  

}
