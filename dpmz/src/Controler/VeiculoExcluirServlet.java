package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;


@WebServlet("/veiculoExcluir")
public class VeiculoExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VeiculoExcluirServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoService veiculoService = new VeiculoService();
		int id_veiculo = Integer.valueOf(request.getParameter("id_veiculo"));
		
		veiculoService.apagarVeiculo(id_veiculo);
		response.sendRedirect("veiculoListar");
	}

}
