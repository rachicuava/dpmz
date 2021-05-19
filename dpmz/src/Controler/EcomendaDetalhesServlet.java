package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;


@WebServlet("/ecomendaDetalhes")
public class EcomendaDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EcomendaDetalhesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncomendaService encomendaService = new EncomendaService();
		int id_encomenda = Integer.valueOf(request.getParameter("id_encomenda"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaDetalhes.jsp");
		request.setAttribute("encomenda", encomendaService.buscarEncaomenda(id_encomenda));
		requestDispatcher.forward(request, response);
	}

	
	
}
