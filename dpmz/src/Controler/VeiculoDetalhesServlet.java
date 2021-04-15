package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;


@WebServlet("/veiculoDetalhes")
public class VeiculoDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VeiculoDetalhesServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoService veiculoService = new VeiculoService();
		int id_veiculo = Integer.valueOf(request.getParameter("id_veiculo"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("veiculoDetalhes.jsp");
		request.setAttribute("veiculo", veiculoService.buscarVeiculo(id_veiculo));
		
		requestDispatcher.forward(request, response);
	}

}
