package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;
import DTO.MotoristaService;

/**
 * Servlet implementation class FuncionarioExcluirServlet
 */
@WebServlet("/motoristaExcluir")
public class MotoristaExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public MotoristaExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MotoristaService motoristaService = new MotoristaService();
		int id_motorista = Integer.valueOf(request.getParameter("id_motorista"));
		motoristaService.apagarMotorista(id_motorista);
		response.sendRedirect("motoristaListar");
		
	}

	
	
}
