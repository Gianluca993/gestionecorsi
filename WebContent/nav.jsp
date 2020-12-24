<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<nav class="navbar navbar-dark menu  navbar-expand-lg">
  <a class="navbar-brand" href="index.jsp"> <i class="fa fa-book"></i>  Impara con noi</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="daticorsisti.jsp">Corsisti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="visualizzastatistiche.jsp">Visualizza</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listacorsi.jsp">Corsi</a>
      </li>
     
    </ul>
  
 
  
  
  <%
				String admin = (String) session.getAttribute("cognome");
			if (admin != null) {
			%>
  


<ul class="ml-auto mr-3 navbar-nav" style="color:white; font-size:16px;">

<li class="nav-item"> <p style="margin-right:25px;">Benvenuto <%=admin %> </p></li>
<li class="nav-item"><a href="logout"> Logout</a></li>


			</ul>

			<%
				} else {
			%>
			
			  <ul class="ml-auto mr-3 navbar-nav ">
  <li class="nav-item"><a href="index.jsp"> <span>
						<i class="fas fa-sign-in-alt"></i></span> Log-in
				</a></li>
			

			<%
				}
			%></ul>
		</div>	
</nav>