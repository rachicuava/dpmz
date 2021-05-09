package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ViagemService;
import Model.Motorista;
import Model.Veiculo;
import Model.Viagem;


@WebServlet("/viagemEditar")
public class ViagemEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViagemEditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    Veiculo veiculo = new Veiculo();
	Viagem viagem = new Viagem(); 
	Motorista motorista = new Motorista();
	ViagemService viagemService = new ViagemService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_viagem = Integer.valueOf(request.getParameter("id_viagem"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viagemEditar.jsp");
		request.setAttribute("viagem", viagemService.buscarViagem(id_viagem));

		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		viagem.setId_viagem(Integer.parseInt(request.getParameter("id_viagem")));
		veiculo.setId_veiculo(Integer.parseInt(request.getParameter("id_veiculo")));
		motorista.setId_motorista(Integer.parseInt(request.getParameter("id_motorista")));
		
		viagem.setDescricao(request.getParameter("descricao"));
		viagem.setOrigem(request.getParameter("origem"));
		viagem.setDestino(request.getParameter("destino"));
		viagem.setVeiculo(veiculo);	
		viagem.setMotorista(motorista);
		
		viagemService.actualizarViagem(viagem);
		
		
		response.sendRedirect("viagemListar");
	}
}
