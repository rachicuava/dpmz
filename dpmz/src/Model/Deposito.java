package Model;


public class Deposito {
	private int id_deposito;
	private String descricao;
	private String bairro;
	private String rua;
	private String email;
	private String telefone;
	private Float longitude;
	private Float latitude;
	
	
	public Deposito() {
		
	}


	public int getId_deposito() {
		return id_deposito;
	}


	public void setId_deposito(int id_deposito) {
		this.id_deposito = id_deposito;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Float getLongitude() {
		return longitude;
	}


	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}


	public Float getLatitude() {
		return latitude;
	}


	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	
	
}
