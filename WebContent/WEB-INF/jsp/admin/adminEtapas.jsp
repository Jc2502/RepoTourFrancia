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
                    <h1><a href="indexPage.html">Le France Tour</a></h1>
                </div>	
                <div class="top-menu">
                    <span class="menu"></span>
                    <ul>
                        <li><a href="indexPage.html">INICIO</a></li>
                        <li class="active"><a href="modifyEquipos.html">Añadir Equipos</a></li>
                        <li><a href="modifyCiclistas.html">Añadir Ciclistas</a></li>
                        <li><a href="adminEtapas.html">Administrar Etapas</a></li>
                        <li><a href="adminPuertos.html">Administrar Puertos</a></li>
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
        <div class="strip">
            <div class="container">
                <div class="dropdown">
                    <form:form method="POST" commandName="etapaBean" action="loadPuerto">
                        <table>
                            <tr>
                                <td>Seleccionar Etapa:</td>
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
        <!-- //header -->
        <!-- banner -->

        <br><br><br>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Numero de la etapa</th>
                        <th>Numero de Kilometros</th>
                        <th>Ciudad Origen</th>
                        <th>Ciudad Destino</th>
                        <th>Ganador de la etapa</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="i" items="${listaEtapas}" varStatus="indexVar">
                        <form:form method="POST" commandName="etapaBean" action="modEtapa">
                            <tr>
                                <td>${i.numeroEtapa}</td>
                                <td>${i.numeroKilometros}</td>
                                <td>${i.ciudadOrigen}</td>
                                <td>${i.ciudadDestino}</td>
                                <td><form:select path="ganador_etapa">
                                        <form:option value="${i.ganador_etapa}" label="${i.ganador_etapa.nombre}" />
                                        <c:forEach var="i" items="${listaCiclistas}">
                                            <form:option value="${i}" label="${i.nombre}" />
                                        </c:forEach> 
                                    </form:select>
                                </td>
                                <td><input type="submit" name="submit" value="Submit"></td>

                            </tr>
                        </form:form>
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
                    >
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //footer -->
    </body>
</html>