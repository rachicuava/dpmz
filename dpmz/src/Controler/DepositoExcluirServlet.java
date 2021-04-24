package Controler;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DepositoService;

/**
 * Servlet implementation class DepositoExcluirServlet
 */
@WebServlet("/depositoExcluir")
public class DepositoExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DepositoExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    DepositoService depositoService = new DepositoService();
	    
		int id_deposito = Integer.valueOf(request.getParameter("id_deposito"));
		depositoService.apagarDeposito(id_deposito);
		response.sendRedirect("depositoListar");
	}

	
}
