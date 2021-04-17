package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DepositoService;
import Model.Deposito;

@WebServlet("/depositoEditar")
public class DepositoEditarServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Deposito deposito = new Deposito();
     DepositoService depositoService = new DepositoService();
    
    public DepositoEditarServle() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_deposito = Integer.valueOf(request.getParameter("id_deposito"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("depositoEditar.jsp");
		request.setAttribute("deposito", depositoService.buscarDepositoPorId(id_deposito));
		
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		deposito.setId_deposito(Integer.valueOf(request.getParameter("id_deposito")));
		deposito.setDescricao(request.getParameter("descricao"));
		deposito.setBairro(request.getParameter("bairro"));
		deposito.setRua(request.getParameter("rua"));
		deposito.setEmail(request.getParameter("email"));
		deposito.setTelefone(request.getParameter("telefone"));
		deposito.setLongitude(request.getParameter("longitude"));
		deposito.setLatitude(request.getParameter("latitude"));
		
		depositoService.actuaizarFuncionario(deposito);
		 response.sendRedirect("depositoListar");
	}

}
