<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1" name="viewport">
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	
    	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
     	<link rel="shortcut icon" type="image/x-icon" href="imagens/favicon.ico">
     	   	   
		<title>SGTM-DPSZ</title>
		
		<script>
				window.addEventListener( "pageshow", function ( event ) {
				var historyTraversal = event.persisted ||
				( typeof window.performance != "undefined" &&
				window.performance.navigation.type === 2 );
				if ( historyTraversal ) {
				window.location.reload();
				}
				}); 
			</script>
			
				<%
				String usuario = null;
				String nivel= null;
				
					Cookie[] cookies = request.getCookies();
					if(cookies !=null){
					for(Cookie cookie : cookies){
					if(cookie.getName().equals("usuarioLogado")) usuario = cookie.getValue();
					if(cookie.getName().equals("usuarioLogadoAcesso")) nivel = cookie.getValue();
					}
					}
					if(usuario == null){
					response.sendRedirect("naoLogado.html");
					}
				%>
		
		
	</head>
	
	<body>
		
		<div class="fixed-top">
		  <div class="collapse" id="navbarToggleExternalContent">
		 	  
		    <div class="bg-dark p-4">
		      <h5 class="text-white h4">SGTM-DPSZ</h5>
		      
			      <a class="nav-link" href="index.jsp">
			      	<svg xmlns="http://www.w3.org/2000/svg" width="28" height="25" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
					  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
					</svg>
			      </a>
		      		<%
		      		if (nivel.equals("admin")){
		      			%>
		      			<a class="nav-link" href="usuarioListar">Usu?rios</a>
		      			<a class="nav-link" href="depositoListar">Dep?sitos</a>
		      			<a class="nav-link" href="veiculoListar">Ve?culos</a>
		      			<a class="nav-link" href="funciorioListar">Funcion?rios</a>
		      			<a class="nav-link" href="motoristaListar">Motoristas</a>
		      			<a class="nav-link" href="viagemListar">Viagens</a>
		      		<% 
		      		
		      		}else if(nivel.equals("Gestor Provincial")){
		      			%>
		      			<a class="nav-link" href="veiculoListar">Ve?culos</a>
		      			<a class="nav-link" href="funciorioListar">Funcion?rios</a>
		      			<a class="nav-link" href="motoristaListar">Motoristas</a>
				        <a class="nav-link" href="viagemListar">Viagens</a>
				     <% 
		      		}else if(nivel.equals("Motorista")){
		      			%>
		      			<a class="nav-link" href="viagemListar">Viagens</a>
		      		<% 
		      		}else{
		      			
		      		}
			     		 %>
			     	<a class="nav-link" href="encomendaListar">Encomendas</a>
			        <hr>
			        <a class="nav-link" href="sobre.jsp">Sobre n?s!</a>
			        
		     
		    </div>
		    
		      
		  </div>
		  <nav class="navbar navbar-dark bg-dark">
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		  </nav>
		
		</div>
		
			<br>
			<br>
							
			<div class="alert alert-dark" role="alert">
				<div align="right">
				<b>Usu?rio activo:</b> <%=usuario%> &nbsp;|&nbsp;
		        <a onclick="return confirm('<%=usuario%> deseja realmente sair do sitema? ')" href="logout" ">
			        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
					  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
					</svg>
		         
		         </a>
		        </div>
		    </div>
	      
			<div class="container">
				<h2><b>Actualizar Ve?culo: </b>${veiculo.fabricante} ${veiculo.modelo}</h2>
				
					<br>
					
					<form action="veiculoEditar" method="post">
							      
				        <div class="row">
				        	<div class="col">
						      <label for="id">ID:</label>
						      <input type="text" name="id_veiculo" class="form-control" readonly="readonly" value="${veiculo.id_veiculo}">
						    </div>
						    
						    <div class="col">
						      <label for="id">Fabricante:</label>
						      <input type="text" name="fabricante" class="form-control" required value="${veiculo.fabricante}">
					 	    </div>
						    
						    <div class="col">
						      <label for="id">Tipo:</label>
						        <input type="text" name="tipo" class="form-control" required value="${veiculo.tipo}">
						      </div>
						    <div class="col">
						        <label for="id">Matr?cula:</label>
						        <input type="text" name="matricula" class="form-control" required value="${veiculo.matricula}">
							 </div>
						</div>
							
							<br>
				        <div class="row">
				        	<div class="col">
				        	  <label for="id">Modelo:</label>
						      <input type="text" name="modelo" class="form-control" required value="${veiculo.modelo}">
						    </div>
						    
				        	<div class="col">
				        	<label for="id">Capacidade:</label>
						     <input type="text" name="capacidade" class="form-control" required value="${veiculo.capacidade}">
						    </div>
						    
						    <div class="col">
						     <label for="id">Ano de fabrico:</label>
						     <input type="text" name="ano_fabrico" class="form-control" required value="${veiculo.ano_fabrico}">
						    </div>
						</div>
						
				        <br>
				        <hr>
				      <div>
				        <a class="btn btn-outline-warning" href="veiculoListar" role="button">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-x-octagon" viewBox="0 0 16 16">
							  <path d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1L1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z"/>
							  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
							</svg>
							Cancelar				
						</a>
				        
				        <button type="submit" class="btn btn-outline-success">
				        	<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-save2" viewBox="0 0 16 16">
							  <path d="M2 1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9.5a1 1 0 0 0-1 1v4.5h2a.5.5 0 0 1 .354.854l-2.5 2.5a.5.5 0 0 1-.708 0l-2.5-2.5A.5.5 0 0 1 5.5 6.5h2V2a2 2 0 0 1 2-2H14a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h2.5a.5.5 0 0 1 0 1H2z"/>
							</svg>
				        	Actualizar
				        </button>
				      </div>
				      					
				  </form>
				</div>

		
		
		
		
		
			
		
		
		
	
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
			
	
   </body>
	
</html>