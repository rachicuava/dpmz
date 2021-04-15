package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;
import Model.Veiculo;

/**
 * Servlet implementation class VeiculoCadastrarServlet
 */
@WebServlet("/veiculoCadastrar")
public class VeiculoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		Veiculo veiculo = new Veiculo();
		VeiculoService veiculoService = new VeiculoService();
   
    public VeiculoCadastrarServlet() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		veiculo.setFabricante(request.getParameter("fabricante"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setTipo(request.getParameter("tipo"));
		veiculo.setCapacidade(request.getParameter("capacidade"));
		veiculo.setMatricula(request.getParameter("matricula"));
		veiculo.setAno_fabrico(Integer.valueOf(request.getParameter("ano_fabrico")));
		
		veiculoService.adicionarVeiculo(veiculo);
		
		response.sendRedirect("veiculoListar");
	}

}
