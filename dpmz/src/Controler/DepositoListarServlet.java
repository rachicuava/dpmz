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


@WebServlet("/depositoListar")
public class DepositoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Deposito deposito = new Deposito();
     DepositoService depositoService = new DepositoService();
   
    public DepositoListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/depositoListar.jsp");
		request.setAttribute("listaDepositos", depositoService.listarDepositos());
		requestDispatcher.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
