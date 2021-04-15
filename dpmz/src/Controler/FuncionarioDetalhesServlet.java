package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;

/**
 * Servlet implementation class FuncionarioDetalhesServlet
 */
@WebServlet("/funcionarioDetalhes")
public class FuncionarioDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FuncionarioDetalhesServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioService funcionarioService = new FuncionarioService(); 
		
		int id_funcionario = Integer.valueOf(request.getParameter("id_funcionario"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("funcionarioDetalhes.jsp");
		request.setAttribute("funcionario", funcionarioService.buscarFuncionario(id_funcionario));
		
		requestDispatcher.forward(request, response);
	}

	
}
