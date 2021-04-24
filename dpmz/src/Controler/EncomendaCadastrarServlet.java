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
import Model.Encomenda;
import Model.Veiculo;




@WebServlet("/encomendaCadastrar")
public class EncomendaCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Veiculo veiculo = new Veiculo();
	Encomenda encomenda = new Encomenda();
	EncomendaService encomendaService = new EncomendaService();
	VeiculoService veiculoService = new VeiculoService();
	
	public EncomendaCadastrarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id_veiculo = Integer.valueOf(request.getParameter("id_veiculo"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaCadastrar.jsp");
		request.setAttribute("veiculo", veiculoService.buscarVeiculo(id_veiculo));
		
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		veiculo.setId_veiculo(Integer.parseInt(request.getParameter("id_veiculo")));
		encomenda.setDescricao(request.getParameter("descricao"));
		encomenda.setVeiculo(veiculo);
		
		encomendaService.adicionarEncomenda(encomenda);
		
		response.sendRedirect("encomendaListar");
	}

}
