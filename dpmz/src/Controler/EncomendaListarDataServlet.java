package Controler;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;


@WebServlet("/encomendaListarData")
public class EncomendaListarDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EncomendaListarDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncomendaService encomendaService = new EncomendaService();
		
		Date inicio = Date.valueOf(request.getParameter("inicio"));
		Date fim = Date.valueOf(request.getParameter("fim"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaListar.jsp");
		request.setAttribute("listaEncomendas", encomendaService.listarEncomendaPorData(inicio, fim));
		
		requestDispatcher.forward(request, response);
	}

	
	
}
