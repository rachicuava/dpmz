package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.VeiculoService;
import Model.Veiculo;


@WebServlet("/veiculoEditar")
public class VeiculoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VeiculoService veiculoService = new VeiculoService();
  	Veiculo veiculo = new Veiculo();
  	
    public VeiculoEditarServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_veiculo = Integer.valueOf(request.getParameter("id_veiculo"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("veiculoEditar.jsp");
		request.setAttribute("veiculo", veiculoService.buscarVeiculo(id_veiculo));
		
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		veiculo.setId_veiculo(Integer.valueOf(request.getParameter("id_veiculo")));
		veiculo.setFabricante(request.getParameter("fabricante"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setTipo(request.getParameter("tipo"));
		veiculo.setCapacidade(request.getParameter("capacidade"));
		veiculo.setMatricula(request.getParameter("matricula"));
		veiculo.setAno_fabrico(Integer.valueOf(request.getParameter("ano_fabrico")));
		
		veiculoService.actualizarVeiculo(veiculo);
		
		response.sendRedirect("veiculoListar");
	}

}
