package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;
import DTO.ViagemService;


@WebServlet("/viagemExcluir")
public class ViagemExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViagemExcluirServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViagemService viagemService = new ViagemService ();
		int id_viagem = Integer.valueOf(request.getParameter("id_viagem"));
		
		viagemService.apagarViagem(id_viagem);
		response.sendRedirect("viagemListar");
	}

}
