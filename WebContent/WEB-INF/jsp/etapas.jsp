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
        <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.6.4/leaflet.css" />

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.6.4/leaflet.js"></script>      
        <script type="text/javascript" src="/TourFrancia/resources/js/geo.js" charset="utf-8"></script>
        <title>Tour de Francia</title>
    </head>
    <body>
        <!-- header -->
        <div class="header">
            <div class="container">
                <div class="logo">
                    <h1><a href="index.html">Le France Tour</a></h1>
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
                        <li><a href="logout">Cerrar Sesion</a></li>
                    </ul>			 
                </div>
                <!-- script-for-menu -->
                <script>
$("span.menu").click(function () {
    $(".top-menu ul").slideToggle("slow", function () {
    });
});
                </script>
                <!-- script-for-menu -->
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //header -->
        <!-- banner -->
        <div class="strip">
            <div class="container">
                <div class="dropdown">
                    <form:form method="POST" commandName="etapaBean" action="loadEtapa">
                        <table>
                            <tr>
                                <td>Please select:</td>
                                <td><form:select path="numeroEtapa">
                                        <form:option value="1" label="1" />
                                        <c:forEach var="i" items="${listaEtapas}">
                                            <form:option value="${i.numeroEtapa}" label="${i.numeroEtapa}" />
                                        </c:forEach>                                    
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
        </div>
        <br><br><br>
        <div class="container">
            <h4>Etapa ${etapa.numeroEtapa} - ${etapa.numeroKilometros} kilometros</h4>
            <h4>Ciudad de origen: ${etapa.ciudadOrigen}</h4>
            <h4>Ciudad de destino: ${etapa.ciudadDestino}</h4>   
            <h4>Ganador: ${etapa.ganador_etapa.nombre} - Dorsal: ${etapa.ganador_etapa.dorsal}</h4>  
            
        <br><br>
        <h4>Puertos: </h4>   
            
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Altura máxima</th>
                        <th>Categoría</th>
                        <th>Dorsal Ganador</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${listaPuertos}">
                        <tr>
                            <td>${i.nombre}</td>
                            <td>${i.alturaMaxima}</td>
                            <td>${i.categoria}</td>
                            <td>${i.dorsalGanador}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- banner -->
        <!-- 404 -->
   
   
        <!-- //404 -->
        <div class="footer">
            <div class="container">
                <div class="copywrite">
                    <p>© 2015 Soccer. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a> </p>
                </div>
                <div class="footer-menu">
                    <ul>
                        <li class="active"><a href="index.html">INICIO</a></li>
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