package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UsuarioService;
import Model.Usuario;


@WebServlet("/usuarioEditar")
public class UsuarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			//Criando novos objectos
			UsuarioService userService = new UsuarioService();
			Usuario user =new Usuario();
   
    public UsuarioEditarServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = Integer.valueOf(request.getParameter("id_usuario"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("usuarioEditar.jsp");
		request.setAttribute("Usuario", userService.buscarUsuario(id_usuario));
		
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user.setId_usuario(Integer.valueOf(request.getParameter("id_usuario")));
		user.setUsuario(request.getParameter("usuario"));
		user.setSenha(request.getParameter("senha"));
		user.setNivel_acesso(request.getParameter("nivel_acesso"));
		user.setTelefone(request.getParameter("telefone"));
		user.setEmail(request.getParameter("email"));
				
		userService.actualizarUsuario(user);
		response.sendRedirect("usuarioListar");
	}

}
