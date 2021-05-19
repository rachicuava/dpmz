package Controler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DTO.VeiculoService;
import Model.Veiculo;

/**
 * Servlet implementation class VeiculoCadastrarServlet
 */
@WebServlet("/veiculoCadastrar")
@MultipartConfig(maxFileSize = 16177215)
public class VeiculoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		Veiculo veiculo = new Veiculo();
		VeiculoService veiculoService = new VeiculoService();
   
    public VeiculoCadastrarServlet() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		veiculo.setFabricante(request.getParameter("fabricante"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setTipo(request.getParameter("tipo"));
		veiculo.setCapacidade(request.getParameter("capacidade"));
		veiculo.setMatricula(request.getParameter("matricula"));
		veiculo.setAno_fabrico(Integer.valueOf(request.getParameter("ano_fabrico")));

		InputStream inputStream = null; // intput para o upload da imagem do veiculo
		Part imagemPart = request.getPart("imagem"); // pegando o parametro imagem do jsp
			System.out.println(imagemPart.getName());
			System.out.println(imagemPart.getSize());
			System.out.println(imagemPart.getContentType());
			try {
				inputStream = imagemPart.getInputStream();
				veiculo.setImagem(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		
		
		
		veiculoService.adicionarVeiculo(veiculo);
		
		response.sendRedirect("veiculoListar");
	}

}
