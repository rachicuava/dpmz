package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UsuarioService;
import DTO.VeiculoService;

/**
 * Servlet implementation class UsuarioListarServlet
 */
@WebServlet("/usuarioListar")
public class UsuarioListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioListarServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UsuarioService userService = new UsuarioService();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("usuarioListar.jsp");
		request.setAttribute("listaUsuarios", userService.listarUsuario());
		requestDispatcher.forward(request, response);
	}


}
