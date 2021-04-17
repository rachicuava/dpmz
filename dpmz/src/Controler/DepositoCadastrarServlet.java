package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DepositoService;
import Model.Deposito;


@WebServlet("/depositoCadastrar")
public class DepositoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Deposito deposito;
       DepositoService depositoService;
   
    public DepositoCadastrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		deposito.setDescricao(request.getParameter("descricao"));
		deposito.setBairro(request.getParameter("bairro"));
		deposito.setRua(request.getParameter("rua"));
		deposito.setEmail(request.getParameter("email"));
		deposito.setTelefone(request.getParameter("telefone"));
		deposito.setLongitude(request.getParameter("longitude"));
		deposito.setLatitude(request.getParameter("latitude"));
		
		depositoService.adicionarDeposito(deposito);
		
	}

}
