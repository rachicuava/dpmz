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
    	
    	<link rel="shortcut icon" type="image/x-icon" href="imagens/favicon.ico">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    	
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
				
		
			<h2><b>Encomendas</b></h2>
			
						
				
				
				 <hr>
				<form action="encomendaListarData" method="get">
					
					   <h4><b>Pesquisar encomendas</b></h4>  
				        <div class="row">
						    <div class="col">
						      <label for="dataInicio"><b>Data in?cio</b></label>
						      <input type="date" name="inicio"  data-date-format="dd/MM/yyyy" class="form-control" placeholder="dd-MM-yyyy">
						    </div>
						    
						    <div class="col">
						      <label for="dataInicio"><b>Data fim</b></label>
						      <input type="date" name="fim"  data-date-format="dd/MM/yyyy" class="form-control" placeholder="dd-MM-yyyy">
						    </div>
						    						    					    
						    <div class="col">
						      <label for="pesquisar"></label>
						      <button type="submit" class="btn btn-outline-dark" >
					       		<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
								</svg>
					       	  Pesquisar
					          </button>
					         </div>
					         
					         <div class="col">
						    
						    </div>
						   		    
						</div>
										
			  </form>
			  
			 
				 <hr>
				
				<br>
				<a class="btn btn-outline-dark" href="encomendaCadastrar.jsp" role="button">
					<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
					  <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
					</svg>
					Nova Encomenda				
				</a>
				
				<br>
				<br>
				<h5>Total de encomendas emitidas: ${listaEncomendas.size()}.</h5>
				<div class="table-responsive">
				<table class="table table-sm table-hover">
				  <thead class="thead-dark">
				    <tr>
				      <th>C?digo</th>
				      <th>Descri??o</th>
				      <th>Matr?cula da viatura</th> 
				      <th>Data da cria??o</th>
				      <th align="center">Ac??es</th>
				      <th>Status</th>
				      <th>Data da entrega</th>
				    </tr>
				  </thead>
				  <tbody>
				  	  <c:forEach items="${listaEncomendas}" var="encomenda">
					    <tr>
					      <th><c:out value="${encomenda.id_encomenda}"/></th>
					      <th><c:out value="${encomenda.descricao}"/></th>
					      <th><c:out value="${encomenda.veiculo.matricula}"/></th>
					      <th><fmt:formatDate pattern="dd/MM/yyyy" value="${encomenda.data}" /></th>    
					      <th>
					      	<a href="ecomendaDetalhes?id_encomenda=${encomenda.id_encomenda}">
								<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-square" viewBox="0 0 16 16">
								  <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
								  <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
								</svg>
							</a>
							&nbsp;|&nbsp;
					      	<a  href="encomendaEditar?id_encomenda=${encomenda.id_encomenda}">
							  	<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="text-warning" viewBox="0 0 16 16">
								  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
								  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
								</svg>
							</a>
							&nbsp;|&nbsp;
							<a onclick="return confirm('Deseja realmente excluir ${encomenda.descricao}?')" href="encomendaExcluir?id_encomenda=${encomenda.id_encomenda}">
								<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"  alt="Apagar" fill="currentColor" class="text-danger" viewBox="0 0 16 16">
								  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
								  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
								</svg>
							</a>
							&nbsp;|&nbsp;
							<a  href="historicoEncomendaCadastar?id_encomenda=${encomenda.id_encomenda}">
								Entregar
							</a>
						 </th>
						 <th><c:out value="${encomenda.status}"/></th>
						 <th><fmt:formatDate pattern="dd/MM/yyyy" value="${encomenda.dataEntrega}" /></th> 
					   </tr>
				    </c:forEach>
				   </tbody>
				</table>
				
			</div>
		</div>
		
		
    	<script type="text/javascript">
    		$('.alert').alert('close')
    	</script>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
				
	</body>
</html>