package Model;

import java.io.InputStream;
import java.util.Date;

public class Encomenda {

	private int id_encomenda;
	private String descricao;
	private Date data;
	private Veiculo veiculo;
	private String status;
	private String comentario;
	private Date dataEntrega;
	private InputStream guia;
	private String criadoPor;
	private String transportadoPor;
	private String recebidoPor;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public InputStream getGuia() {
		return guia;
	}

	public void setGuia(InputStream guia) {
		this.guia = guia;
	}

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public String getTransportadoPor() {
		return transportadoPor;
	}

	public void setTransportadoPor(String transportadoPor) {
		this.transportadoPor = transportadoPor;
	}

	public String getRecebidoPor() {
		return recebidoPor;
	}

	public void setRecebidoPor(String recebidoPor) {
		this.recebidoPor = recebidoPor;
	}

}
