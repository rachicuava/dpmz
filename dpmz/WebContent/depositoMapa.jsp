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
		
		<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
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
				
				<style type="text/css">
					#map {
				        height: 100%;
				      }
				
				      /* Optional: Makes the sample page fill the window. */
				      html,
				      body {
				        height: 100%;
				        margin: 0;
				        padding: 0;
				      }
			    </style >
			    
			    <script>
			    // In the following example, markers appear when the user clicks on the map.
			      // Each marker is labeled with a single alphabetical character.
			      const labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			      let labelIndex = 0;

			      function initMap() {
			        const bangalore = { lat: -17.876727, lng: 36.883734 };
			        const map = new google.maps.Map(document.getElementById("map"), {
			          zoom: 12,
			          center: bangalore,
			        });
			        // This event listener calls addMarker() when the map is clicked.
			        google.maps.event.addListener(map, "click", (event) => {
			          addMarker(event.latLng, map);
			        });
			        // Add a marker at the center of the map.
			        addMarker(bangalore, map);
			      }

			      // Adds a marker to the map.
			      function addMarker(location, map) {
			        // Add the marker at the clicked location, and add the next-available label
			        // from the array of alphabetical characters.
			        new google.maps.Marker({
			          position: location,
			          label: labels[labelIndex++ % labels.length],
			          map: map,
			        });
			      }
			    </script>
		
		
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
	      
			<div class="container" >
				<div id="map"></div>

			</div> 
			
    
	    
	    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
	    <script
		    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVNDmodh2vlQ99saVvqwSOjk8eYOfnk8M&callback=initMap&libraries=&v=weekly"
	      	async
	    ></script>
		
	
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
			
	
   </body>
	
</html>