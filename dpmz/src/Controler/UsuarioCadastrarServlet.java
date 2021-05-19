package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UsuarioService;
import Model.Usuario;

/**
 * Servlet implementation class UsuarioCadastrarServlet
 */
@WebServlet("/usuarioCadastrar")
public class UsuarioCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Usuario user = new Usuario();
       UsuarioService userService = new UsuarioService();
    
    public UsuarioCadastrarServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user.setUsuario(request.getParameter("usuario"));
		user.setSenha(request.getParameter("senha"));
		user.setNivel_acesso(request.getParameter("nivel_acesso"));
		user.setTelefone(request.getParameter("telefone"));
		user.setEmail(request.getParameter("email"));
		
		userService.adicionarUsuario(user);
		response.sendRedirect("usuarioListar");
	}

}
