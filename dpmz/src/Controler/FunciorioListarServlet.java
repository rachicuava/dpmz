package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;
import Model.Funcionario;


@WebServlet("/funciorioListar")
public class FunciorioListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Funcionario funcionario = new Funcionario();
		FuncionarioService funcionarioService = new FuncionarioService();
   
    public FunciorioListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/funcionarioListar.jsp");
		request.setAttribute("listaFuncionarios", funcionarioService.listarFuncionario());
				
		requestDispatcher.forward(request, response);
	}

}
