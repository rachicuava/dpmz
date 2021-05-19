package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;

import Model.Encomenda;



@WebServlet("/historicoEncomendaCadastar")
public class HistoricoEncomendaCadastarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HistoricoEncomendaCadastarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	EncomendaService encomendaService = new EncomendaService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_encomenda = Integer.valueOf(request.getParameter("id_encomenda"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaEntregar.jsp");
		request.setAttribute("encomenda", encomendaService.buscarEncomenda(id_encomenda));
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Encomenda encomenda = new Encomenda();
		encomenda.setId_encomenda(Integer.valueOf(request.getParameter("id_encomenda")));
		encomenda.setStatus(request.getParameter("status"));
		encomenda.setComentario(request.getParameter("comentario"));
		encomendaService.entrgarEncomenda(encomenda);
		
		response.sendRedirect("encomendaListar");
		
	}

}
