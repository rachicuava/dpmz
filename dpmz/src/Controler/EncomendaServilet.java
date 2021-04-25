package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EncomendaService;
import DTO.VeiculoService;
import Model.Encomenda;
import Model.Veiculo;


@WebServlet("/encomenda")
public class EncomendaServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static String adicionar = "/ecomendaCadastrar.jsp";
	//private static String editar = "/ecomendaEditar.jsp";
	//private static String listar = "/ecomendaListar.jsp";
	
		Veiculo veiculo = new Veiculo();
		Encomenda encomenda = new Encomenda();
		EncomendaService encomendaService = new EncomendaService();
		VeiculoService veiculoService = new VeiculoService();
   
    public EncomendaServilet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	String accao = request.getParameter("accao");
    	
		if (accao.equalsIgnoreCase("excluir")){
			int id_encomenda = Integer.valueOf(request.getParameter("id_encomenda"));
			encomendaService.apagarEcomenda(id_encomenda);
			response.sendRedirect("encomendaListar.jsp");
			
		}else if(accao.equalsIgnoreCase("listar")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaListar.jsp");
			request.setAttribute("listaEncomendas", encomendaService.listarEncomenda());
			
			requestDispatcher.forward(request, response);
			
		}else if(accao.equalsIgnoreCase("buscar")){
			int id_encomenda = Integer.valueOf(request.getParameter("id_encomenda"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("encomendaEditar.jsp");
			request.setAttribute("encomenda", encomendaService.buscarEncomenda(id_encomenda));
			
			requestDispatcher.forward(request, response);
			
		}
		
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String accao = request.getParameter("accao");
	
		if (accao.equalsIgnoreCase("adicionar")){
			
			veiculo.setId_veiculo(Integer.parseInt(request.getParameter("id_veiculo")));
			encomenda.setDescricao(request.getParameter("descricao"));
			encomenda.setVeiculo(veiculo);
			
			encomendaService.adicionarEncomenda(encomenda);
			response.sendRedirect("encomendaListar");
			
		}else if(accao.equalsIgnoreCase("editar")){
			
			veiculo.setId_veiculo(Integer.parseInt(request.getParameter("id_veiculo")));
			encomenda.setId_encomenda(Integer.valueOf(request.getParameter("id_encomenda")));
			encomenda.setDescricao(request.getParameter("descricao"));
			encomenda.setVeiculo(veiculo);
			
			encomendaService.actualizarEncomenda(encomenda);;
			response.sendRedirect("encomendaListar");
			
			
		}
		
	}


}
