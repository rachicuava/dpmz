package Controler;

import java.io.IOException;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FuncionarioService;
import Model.Funcionario;

/**
 * Servlet implementation class FuncionarioCadastrarServilet
 */
@WebServlet("/funcionarioCadastrar")
public class FuncionarioCadastrarServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Funcionario funcionario = new Funcionario();
	 FuncionarioService funcionarioService = new FuncionarioService(); 
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     
    public FuncionarioCadastrarServilet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Buscando os parâmetros no formulario de cadastro de funcionario	
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
			
			funcionarioService.adicionarFuncionario(funcionario);
		    		
	        response.sendRedirect("funciorioListar");
		
	}

}
