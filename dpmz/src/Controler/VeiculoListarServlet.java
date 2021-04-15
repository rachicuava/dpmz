package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;

@WebServlet("/veiculoListar")
public class VeiculoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VeiculoListarServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoService veiculoService = new VeiculoService();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("veiculoListar.jsp");
		request.setAttribute("listaVeiculos", veiculoService.listarVeiculo());
		requestDispatcher.forward(request, response);
	}

}
