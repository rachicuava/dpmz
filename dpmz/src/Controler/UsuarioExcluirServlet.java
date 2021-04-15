package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UsuarioService;


@WebServlet("/usuarioExcluir")
public class UsuarioExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioExcluirServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService userService = new UsuarioService();
		int id_usuario = Integer.valueOf(request.getParameter("id_usuario"));
		userService.apagarUsuario(id_usuario);
		response.sendRedirect("usuarioListar");

	}

	
}
