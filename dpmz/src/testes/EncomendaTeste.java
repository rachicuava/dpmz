package testes;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import DAO.ConnectionFactory;
import DTO.EncomendaService;
import Model.Encomenda;
import Model.Veiculo;

public class EncomendaTeste {

	@Test
	public void adiciionar() throws SQLException {
		Encomenda e = new Encomenda();
		e.setDescricao("Kit APE");

		Veiculo v = new Veiculo();
		v.setId_veiculo(2);
		e.setVeiculo(v);

		EncomendaService es = new EncomendaService();
		es.adicionarEncomenda(e);

	}

	@Test
	@Ignore
	public static void main(String[] args) {

		EncomendaService es = new EncomendaService();

		for (Encomenda e : es.listarEncomenda()) {
			System.out.println(" Descricao da encomenda:  " + e.getDescricao()
					+ " Matricula do veiculo que transporta: " + e.getVeiculo().getMatricula());

		}
	}

	

}
