<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				 <li><a href="index.html">INICIO</a></li>
				 <li class="active"><a href="galeria.html">GALERIA</a></li>
				 <li><a href="laCarrera.html">LA CARRERA</a></li>
                                 <li><a href="entrenamientos.html">ENTRENAMIENTOS</a></li>
				 <li><a href="noticias.html">NOTICIAS & EVENTOS</a></li>
				 <li><a href="contacto.html">CONTACTO</a></li>
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
<div class="strip">
	 <div class="container">
	 <div class="search">
		    <form>
		    	<input type="text" value="" placeholder="Search...">
				<input type="submit" value="">
			</form>
     </div>     
	 <div class="social">			 
			 <a href="#"><i class="facebook"></i></a>
			 <a href="#"><i class="twitter"></i></a>
			 <a href="#"><i class="dribble"></i></a>	
			 <a href="#"><i class="google"></i></a>	
			 <a href="#"><i class="youtube"></i></a>	
	 </div>
		<div class="clearfix"></div>
		</div>
</div>
<!-- banner -->
<!-- 404 -->
<div class="error">
	 <div class="container">
		  <div class="error-main">
				<h3>404<span>error</span>
				<h5>Page not found</h5>
				<p>We are sorry but the page you are looking for does not exit.
				You could return to the homepage</p>
				<a href="../../index.html">BACK TO HOME</a>
		 </div>
	 </div>
</div>
<!-- //404 -->
<!--footer-->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>© 2015 Soccer. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a> </p>
		 </div>
		 <div class="footer-menu">
			 <ul>
				 <li><a href="index.html">INICIO</a></li>
				 <li><a href="galeria.html">GALERIA</a></li>
				 <li><a href="laCarrera.html">LA CARRERA</a></li>
				 <li><a href="entrenamientos.html">ENTRENAMIENTOS</a></li>
				 <li><a href="noticias.html">NOTICIAS & EVENTOS</a></li>
				 <li><a href="contacto.html">CONTACTO</a></li>
			 </ul>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!-- //footer -->
</body>
</html>