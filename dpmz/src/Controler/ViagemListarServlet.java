package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;
import DTO.ViagemService;


@WebServlet("/viagemListar")
public class ViagemListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViagemListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViagemService viagemService = new ViagemService();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viagemListar.jsp");
		request.setAttribute("listaViagens", viagemService.listarViagem());
		
		requestDispatcher.forward(request, response);
	}

}
