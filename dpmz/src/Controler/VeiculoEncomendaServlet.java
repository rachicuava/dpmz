package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;


@WebServlet("/veiculoEncomenda")
public class VeiculoEncomendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VeiculoEncomendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoService veiculoService = new VeiculoService();
		int id_veiculo = Integer.valueOf(request.getParameter("id_veiculo"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaCadastrar.jsp");
		request.setAttribute("veiculo", veiculoService.buscarVeiculo(id_veiculo));
		
		requestDispatcher.forward(request, response);
	}

	

}
