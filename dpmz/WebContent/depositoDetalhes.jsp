<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		      		System.out.println(nivel);
		      		if (nivel.equals("admin")){
		      			%>
		      			<a class="nav-link" href="usuarioListar">Usuários</a>
		      			<a class="nav-link" href="depositoListar">Depósitos</a>
		      			<a class="nav-link" href="veiculoListar">Veículos</a>
		      			<a class="nav-link" href="funciorioListar">Funcionários</a>
		      			<a class="nav-link" href="viagemListar">Viagens</a>
		      		<% 
		      		
		      		}else if(nivel.equals("Gestor Provincial")){
		      			%>
		      			<a class="nav-link" href="veiculoListar">Veículos</a>
		      			<a class="nav-link" href="funciorioListar">Funcionários</a>
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
			        <a class="nav-link" href="sobre.jsp">Sobre nós!</a>
			        
		     
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
				<b>Usuário activo:</b> <%=usuario%> &nbsp;|&nbsp;
		        <a onclick="return confirm('<%=usuario%> deseja realmente sair do sitema? ')" href="logout" ">
			        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
					  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
					</svg>
		         
		         </a>
		        </div>
		    </div>
	      
			<div class="container">
				<h2><b>Detalhes do Depósito</b></h2>
				
				<br>
			<div>  
		        <a class="btn btn-outline-dark" href="depositoListar" role="button">
					<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-arrow-90deg-left" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M1.146 4.854a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H12.5A2.5 2.5 0 0 1 15 6.5v8a.5.5 0 0 1-1 0v-8A1.5 1.5 0 0 0 12.5 5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4z"/>
					</svg>
					Voltar				
				</a>
			</div>  
			<br>
			<div> 
				<table border="0">
						<tr>
							<th><label for="id_deposito">ID</label></th>
								<td><input type="text" name="id_deposito" readonly="readonly" class="form-control" value="${deposito.id_deposito}"></td>
							</tr>
						<tr>
							<th><label for="descricao">Descrição:</label></th>
								<td><input type="text" name="descricao" readonly="readonly" class="form-control" value="${deposito.descricao}"></td>
						</tr>
						<tr>
							<th><label for="bairro">Bairro:</label></th>
							<td><input type="text" name="bairro" readonly="readonly" class="form-control" value="${deposito.bairro}"></td>
						</tr>
						<tr>
							<th><label for="rua">Rua:</label></th>
							<td><input type="text" name="rua" readonly="readonly" class="form-control" value="${deposito.rua}"></td>
						</tr>
						<tr>
							<th><label for="email">Email:</label></th>
							<td><input type="text" name="email" readonly="readonly" class="form-control" value="${deposito.email}"></td>
						</tr>
						<tr>
							<th><label for="telefone">Telefone:</label></th>
							<td><input type="text" name="telefone" readonly="readonly" class="form-control" value="${deposito.telefone}"></td>
						</tr>
						<tr>
							<th><label for="latitude">Latitude:</label></th>
							<td><input type="text" name="latitude" readonly="readonly" class="form-control" value="${deposito.latitude}"></td>
						</tr>
						<tr>
							<th><label for="latitude">Longitude:</label></th>
							<td><input type="text" name="longitude" readonly="readonly" class="form-control" value="${deposito.longitude}"></td>
						</tr>
					</table>
				</div> 
			</div> 
	
		
		
		
		
			
		
		
		
	
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
			
	
   </body>
	
</html>