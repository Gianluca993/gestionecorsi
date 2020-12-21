<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#menuapp" aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="menuapp">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="registra.jsp"> <span
						class="glyphicon glyphicon-user"></span> Sign-up
				</a></li>

				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-in"></span> Log-in
				</a></li>



			</ul>

		
				<ul class="nav navbar-nav">
			<li><a href="acquisti.jsp">Acquisti</a></li>
			<li><a href="visualizza.jsp">Riepilogo ordine</a></li>
			
			
			</ul>
			
	
			<ul class="nav navbar-nav navbar-right">
				<li><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        
        </a>  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="visualizzautente.jsp" style="color:black;">Visualizza Utente</a>
          <a class="dropdown-item" href="modificautente.jsp" style="color:black;">Modifica Utente</a>
         
        </div>
				</li>

				<li><a href="logout.jsp"> <span
						class="glyphicon glyphicon-off"></span> Logout
				</a></li>

			</ul>

		</div>

	</div>
</nav>