package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DTO.MotoristaService;

@WebServlet("/motoristaListar")
public class MotoristaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MotoristaService motoristaService = new MotoristaService();

	public MotoristaListarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/motoristaListar.jsp");
		request.setAttribute("listaMotoristas", motoristaService.listarMotorista());

		requestDispatcher.forward(request, response);
	}

}
