<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Francois+One'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Cabin:400,500,600,700'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Audiowide'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!--//fonts-->

<!-- let's add tag srping:url -->
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />
<spring:url value="/resources/css/responsiveslides.css"
	var="responsiveSlidesCSS" />
<spring:url value="/resources/js/responsiveslides.min.js"
	var="responsiveSlidesJS" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
<link href="${responsiveSlidesCSS}" rel="stylesheet" />

<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Soccer Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->

<!-- Finish adding tags -->

<title>Tour de Francia</title>
</head>
<body>
<!-- header -->
<div class="header">
	 <div class="container">
		 <div class="logo">
			   <h1><a href="index.html">SOCCER</a></h1>
		 </div>	
		 <div class="top-menu">
			 <span class="menu"></span>
			  <ul>
                        <li class="active"><a href="index.html">INICIO</a></li>
                        <li><a href="ciclistas.html">CICLISTAS</a></li>
                        <li><a href="equipos.html">LOS EQUIPOS</a></li>
                        <li><a href="etapas.html">LAS ETAPAS</a></li>
                        <li><a href="puertos.html">LOS PUERTOS</a></li>
                        <li><a href="contacto.html">CONTACTO</a></li>
                        <li><a>Bienvenido ${loggedInUser} </a></li>
			 </ul>			 
		 </div>
		 <!-- script-for-menu -->
		 <script>
				$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){
					});
				});
		 </script>
		 <!-- script-for-menu -->
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //header -->
<!-- banner -->

<div class="container">

            <div class="search">

                <form:form method="POST" commandName="equipoBean">
                    <table>
                        <tr>
                            <td>Please select:</td>
                            <td><form:select path="nombre">
                                    <form:option value="" label="...." />
                                    <form:options items="${listaEquipos}" />
                                </form:select>
                            </td>

                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" value="Submit"></td>
                        </tr>
                        <tr>
                    </table>
                </form:form>
            </div>
        </div>
<br>
<br>
<br>
<div class="container">
    
        Ciclistas del Equipo ${equipo}
    <ul>
        <c:forEach var="i" items="${ciclistas}">
            <li><c:out value="${i.nombre}"/><p></li>
        </c:forEach>
     </ul>
</div>
<!-- banner -->

<!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>© 2015 Soccer. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a> </p>
		 </div>
		 <div class="footer-menu">
			 <ul>
                            <li><a href="index.html">INICIO</a></li>
                            <li><a href="ciclistas.html">CICLISTAS</a></li>
                            <li><a href="equipos.html">LOS EQUIPOS</a></li>
                            <li><a href="etapas.html">LAS ETAPAS</a></li>
                            <li><a href="puertos.html">LOS PUERTOS</a></li>
                            <li><a href="contacto.html">CONTACTO</a></li>
			 </ul>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //footer -->
</body>
</html>