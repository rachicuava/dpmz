package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;


@WebServlet("/encomendaListar")
public class EncomendaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EncomendaListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncomendaService encomendaService = new EncomendaService();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaListar.jsp");
		request.setAttribute("listaEncomendas", encomendaService.listarEncomenda());
		
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
