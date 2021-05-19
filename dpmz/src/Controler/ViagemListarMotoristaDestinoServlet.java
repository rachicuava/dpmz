package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ViagemService;


@WebServlet("/viagemListarMotoristaDestino")
public class ViagemListarMotoristaDestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViagemListarMotoristaDestinoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViagemService viagemService = new ViagemService();
		String motorista1 = request.getParameter("motorista");
		String destino = request.getParameter("destino");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viagemListar.jsp");
		request.setAttribute("listaViagens", viagemService.listarViagemPorMotoristaDestino(motorista1, destino));
		
		requestDispatcher.forward(request, response);
	}

}
