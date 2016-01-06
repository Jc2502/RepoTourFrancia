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
                    <h1><a href="indexPage.html">Le France Tour</a></h1>
                </div>	
                <div class="top-menu">
                    <span class="menu"></span>
                    <ul>
                        <li><a href="indexPage.html">INICIO</a></li>
                        <li class="active"><a href="modifyEquipos.html">Administrar Equipos</a></li>
                        <li><a href="modifyCiclistas.html">Administrar Ciclistas</a></li>
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
        <!-- //header -->
        <!-- banner -->
        
        <!-- banner -->
        <div class="strip">
            <div class="container">
                <div class="dropdown">
                    <form:form method="POST" action="loadEquipo" commandName="equipoBean">
                        <table>
                            <tr>
                                <td>Please select:</td>
                                <td><form:select path="nombre">
                                        <ul class="dropdown-menu">
                                            <li><form:option value="" label="Nuevo Equipo"/></li>
                                                <c:forEach var="i" items="${listaEquipos}">
                                                    <form:option value="${i.nombre}" label="${i.nombre}" />
                                                </c:forEach>  
                                        </ul>
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

        <br>
        <br>
        <br>

        <form:form method="POST" action="modEquipo" commandName="equipoBean" >
            <div class="container">
                <h2>Datos del equipo</h2>
                <p></p>            
                <table class="table">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><h4>Nombre del Equipo</h4></td>
                            <td><form:input id="nombre" name="nombre" path="nombre"/><br></td>
                        </tr>
                        <tr>
                            <td><h4>Nombre del director</td>
                            <td><form:input id="nombreDirector" name="nombreDirector"  path="nombreDirector" /><br></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" value="Update"></td>
                            <td><input type="submit" name="submit" value="Remove"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form:form>

        <!--footer-->
        <div class="footer">
            <div class="container">
                <div class="copywrite">
                    <p>© 2015 Soccer. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a> </p>
                </div>
                <div class="footer-menu">

                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //footer -->
    </body>
</html>