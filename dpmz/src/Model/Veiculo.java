package Model;

import java.io.InputStream;


public class Veiculo {
	
	private int id_veiculo;
	private String fabricante;
	private String modelo;
	private String tipo;
	private String capacidade;
	private String matricula;
	private int ano_fabrico;
	private InputStream imagem;
	
	
	public Veiculo() {
	}
	
	
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAno_fabrico() {
		return ano_fabrico;
	}
	public void setAno_fabrico(int ano_fabrico) {
		this.ano_fabrico = ano_fabrico;
	}
	public InputStream getImagem() {
		return imagem;
	}
	public void setImagem(InputStream imagem) {
		this.imagem = imagem;
	}
	
		
}
