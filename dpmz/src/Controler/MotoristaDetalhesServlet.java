package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;
import DTO.MotoristaService;

/**
 * Servlet implementation class FuncionarioDetalhesServlet
 */
@WebServlet("/motoristaDetalhes")
public class MotoristaDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MotoristaDetalhesServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MotoristaService motoristaService = new MotoristaService(); 
		
		int id_motorista = Integer.valueOf(request.getParameter("id_motorista"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("motoristaDetalhes.jsp");
		request.setAttribute("motorista", motoristaService.buscarMotorista(id_motorista));
		
		requestDispatcher.forward(request, response);
	}

	
}
