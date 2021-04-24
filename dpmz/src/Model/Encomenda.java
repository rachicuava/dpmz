package Model;

import java.util.Date;

public class Encomenda {

	private int id_encomenda;
	private String descricao;
	private Date data;
	private Veiculo veiculo;

	public int getId_encomenda() {
		return id_encomenda;
	}

	public void setId_encomenda(int id_encomenda) {
		this.id_encomenda = id_encomenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
