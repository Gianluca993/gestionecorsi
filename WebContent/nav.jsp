<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp"> <i class="fa fa-book"></i>  Impara con noi</a>
  <%
				String admin = (String) session.getAttribute("cognome");
			if (admin != null) {
			%>
  


<ul class="row mx-4" style="color:white; font-size:12px;">

<li> <p style="margin-right:25px;">Benvenuto <%=admin %> </p></li>
<li><a href="logout"> Logout</a></li>


			</ul>

			<%
				} else {
			%>
			
			  <ul>
  <li><a href="index.jsp"> <span>
						<i class="fas fa-sign-in-alt"></i></span> Log-in
				</a></li>
			

			<%
				}
			%></ul>
			
</nav>