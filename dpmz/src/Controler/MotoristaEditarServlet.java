package Controler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;
import DTO.MotoristaService;
import Model.Funcionario;
import Model.Motorista;

@WebServlet("/motoristaEditar")
public class MotoristaEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Motorista motorista = new Motorista();
	 MotoristaService motoristaService = new MotoristaService(); 
   
    public MotoristaEditarServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_motorista = Integer.valueOf(request.getParameter("id_motorista"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("motoristaEditar.jsp");
		request.setAttribute("motorista", motoristaService.buscarMotorista(id_motorista));
		
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Buscando os parâmetros no formulario de actualizacao de motorista
		motorista.setId_motorista(Integer.valueOf(request.getParameter("id_motorista")));
	    motorista.setNome(request.getParameter("nome"));
		motorista.setApelido(request.getParameter("apelido"));
		motorista.setSexo(request.getParameter("sexo"));
		motorista.setEmail(request.getParameter("email"));
		motorista.setTelefone(request.getParameter("telefone"));
		motorista.setDistrito(request.getParameter("distrito"));
		motorista.setBairro(request.getParameter("bairro"));
		motorista.setRua(request.getParameter("rua"));
	    
		 String data = request.getParameter("data_nascimento");
		    System.out.println(data);
		    		   
		    Date data_nascimento;
			try {
					data_nascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_nascimento"));
					motorista.setData_nascimento(data_nascimento);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			
	    
		motoristaService.actualizarMotorista(motorista);
	    
	   	    
        response.sendRedirect("motoristaListar");
	
	}

}
