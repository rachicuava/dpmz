package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;
import DTO.VeiculoService;
import DTO.ViagemService;
import Model.Encomenda;
import Model.Motorista;
import Model.Veiculo;
import Model.Viagem;




@WebServlet("/viagemCadastrar")
public class ViagemCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Veiculo veiculo = new Veiculo();
	Viagem viagem = new Viagem(); 
	Motorista motorista = new Motorista();
	ViagemService viagemService = new ViagemService();
	
	public ViagemCadastrarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		veiculo.setId_veiculo(Integer.parseInt(request.getParameter("id_veiculo")));
		motorista.setId_motorista(Integer.parseInt(request.getParameter("id_motorista")));
		
		viagem.setDescricao(request.getParameter("descricao"));
		viagem.setOrigem(request.getParameter("origem"));
		viagem.setDestino(request.getParameter("destino"));
		viagem.setVeiculo(veiculo);	
		viagem.setMotorista(motorista);
		
		viagemService.adicionarViagem(viagem);;
		
		
		response.sendRedirect("viagemListar");
	}

}
