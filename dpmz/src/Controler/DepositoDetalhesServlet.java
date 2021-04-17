package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DepositoService;
import Model.Deposito;


@WebServlet("/depositoDetalhes")
public class DepositoDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Deposito deposito = new Deposito();
	    DepositoService depositoService = new DepositoService();
	   
    public DepositoDetalhesServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_deposito = Integer.valueOf(request.getParameter("id_deposito"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("depositoDetalhes.jsp");
		request.setAttribute("deposito", depositoService.buscarDepositoPorId(id_deposito));
		
		requestDispatcher.forward(request, response);
	}


}
