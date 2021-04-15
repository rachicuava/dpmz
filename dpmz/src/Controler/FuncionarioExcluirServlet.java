package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;

/**
 * Servlet implementation class FuncionarioExcluirServlet
 */
@WebServlet("/funcionarioExcluir")
public class FuncionarioExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public FuncionarioExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioService funcionarioService = new FuncionarioService();
		int id_funcionario = Integer.valueOf(request.getParameter("id_funcionario"));
		funcionarioService.apagarFuncionario(id_funcionario);
		response.sendRedirect("funciorioListar");
		
	}

	
	
}
