package Model;

import java.sql.Date;

public class Deposito {
	private int id_deposito;
	private String nome;
	private String longitude;
	private String latitude;
	private Date actualizado_em;
	
	
	public Deposito(int id_deposito, String nome, String longitude, String latitude, Date actualizado_em) {
		super();
		this.id_deposito = id_deposito;
		this.nome = nome;
		this.longitude = longitude;
		this.latitude = latitude;
		this.actualizado_em = actualizado_em;
	}


	public Deposito() {
		// TODO Auto-generated constructor stub
	}


	public int getId_deposito() {
		return id_deposito;
	}


	public void setId_deposito(int id_deposito) {
		this.id_deposito = id_deposito;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public Date getActualizado_em() {
		return actualizado_em;
	}


	public void setActualizado_em(Date actualizado_em) {
		this.actualizado_em = actualizado_em;
	}
	
	
	

}
