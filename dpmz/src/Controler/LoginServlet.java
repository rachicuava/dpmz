package Controler;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DTO.UsuarioService;
import Model.Usuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

  
    public LoginServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    UsuarioService usuarioService = new UsuarioService();
	    
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = usuarioService.usuarioLogin(usuario, senha);
		
		
	
		if (user.getUsuario()!=null) {
					
			Cookie loginCookie = new Cookie("usuarioLogado",usuario);
			Cookie loginCookie2 = new Cookie("usuarioLogadoAcesso",user.getNivel_acesso());
			
		//ESPECIFICANDO QUE O COOKIE EXPIRA EM 30 MINUTOS
			loginCookie.setMaxAge(30*60); 
			response.addCookie(loginCookie);
			
			loginCookie2.setMaxAge(30*60); 
			response.addCookie(loginCookie2);
			
			response.sendRedirect("index.jsp");
			
		} else {
			response.sendRedirect("loginErro.html");
		}
		doGet(request, response);
	}

}
