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
import Model.Funcionario;

@WebServlet("/funcionarioEditar")
public class FuncionarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Funcionario funcionario = new Funcionario();
	 FuncionarioService funcionarioService = new FuncionarioService(); 
   
    public FuncionarioEditarServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_funcionario = Integer.valueOf(request.getParameter("id_funcionario"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("funcionarioEditar.jsp");
		request.setAttribute("funcionario", funcionarioService.buscarFuncionario(id_funcionario));
		
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Buscando os parâmetros no formulario de actualizacao de funcionario	
	    funcionario.setId_funcionario(Integer.valueOf(request.getParameter("id_funcionario")));
		funcionario.setNome(request.getParameter("nome"));
	    funcionario.setApelido(request.getParameter("apelido"));
	    funcionario.setCategoria(request.getParameter("categoria"));
	    funcionario.setSexo(request.getParameter("sexo"));
	    funcionario.setNuit(Integer.valueOf(request.getParameter("nuit")));
	    funcionario.setEmail(request.getParameter("email"));
	    funcionario.setTelefone(request.getParameter("telefone"));
	    funcionario.setDistrito(request.getParameter("distrito"));
	    funcionario.setBairro(request.getParameter("bairro"));
	    funcionario.setRua(request.getParameter("rua"));
	    
	    String data = request.getParameter("data_nascimento");
	    System.out.println(data);
	    		   
	    Date data_nascimento;
		try {
				data_nascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_nascimento"));
				funcionario.setData_nascimento(data_nascimento);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	    
	    funcionarioService.actualizarFuncionario(funcionario);
	    
	    String alerta = "Funcionário actualizado!";
	    request.setAttribute("alerta",alerta);
	    
        response.sendRedirect("funciorioListar");
	
	}

}
