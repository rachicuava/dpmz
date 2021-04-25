package Model;

import java.util.Date;

public class Viagem {
	private int id_viagem;
	private String descricao;
	private String origem;
	private String destino;
	private Date data;
	private Veiculo veiculo;
	private Motorista motorista;
	
	public Viagem (){
		
	}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
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

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
}
