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


@WebServlet("/depositoMapa")
public class DepositoMapaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Deposito deposito = new Deposito();
	    DepositoService depositoService = new DepositoService();
    public DepositoMapaServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("depositoMapa.jsp");
		request.setAttribute("deposito", depositoService.listarDepositos());
		
		requestDispatcher.forward(request, response);
	}


}
