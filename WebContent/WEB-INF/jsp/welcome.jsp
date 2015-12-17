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
				<h1>
					<a href="index.html">Le Tour de Francia</a>
				</h1>
			</div>
			<div class="top-menu">
				<span class="menu"></span>
				<ul>
					<li class="active"><a href="index.html">HOME</a></li>
					<li><a href="gallery.html">GALERIA</a></li>
					<li><a href="404.html">LA CARRERA</a></li>
					<li><a href="event.html">NOTICIAS</a></li>
					<li><a href="contact.html">CONTACTO</a></li>
				</ul>
			</div>
			<!-- script-for-menu -->
			<script>
				$("span.menu").click(function() {
					$(".top-menu ul").slideToggle("slow", function() {
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
					<input type="text" value="" placeholder="Buscar..."> <input
						type="submit" value="">
				</form>
			</div>
			<div class="social">
				<a href="https://www.facebook.com/letour/"><i class="facebook"></i></a>
				<a href="https://twitter.com/letour?lang=es"><i class="twitter"></i></a>
				<a href="https://plus.google.com/+LeTourDeFrance"><i
					class="google"></i></a> <a
					href="https://www.youtube.com/user/letourdefrance"><i
					class="youtube"></i></a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- banner -->
	<div class="banner">
		<script src="${responsiveSlidesJS}"></script>
		<script>
			$(function() {
				$("#slider").responsiveSlides({
					auto : true,
					speed : 300,
					manualControls : '#slider3-pager',
				});
			});
		</script>

		<div class="slider">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li>
					<img src="<%=request.getContextPath()%>/resources/images/bnr3.jpg"/>
					<!--<img src="/TourFrancia/WebContent/resources/images/bnr3.jpg" alt="">-->
						<div class="banner-info">
							<h3>Sed ultricies elementum.</h3>
							<p>Lorem Interdum et malesuada fames ac ante ipsum primis in
								faucibus. Donec a odio quam. Aenean ipsum arcu, luctus vel
								ultricies ut, commodo sed turpis. Phasellus tristique lorem sit
								amet tellus dignissim hendrerit. In hac habitasse platea
								dictumst. Sed vehicula volutpat varius elit. consectetur
								adipiscing elit.</p>
						</div></li>
					<li>
					<img src="<%=request.getContextPath()%>/resources/images/bnr2.jpg"/>
					<!--<img src="/TourFrancia/WebContent/resources/images/bnr2.jpg" alt=""> -->
						<div class="banner-info">
							<h3>Curabitur turpis posuere rutrum.</h3>
							<p>Lorem Interdum et malesuada fames ac ante ipsum primis in
								faucibus. Donec a odio quam. Aenean ipsum arcu, luctus vel
								ultricies ut, commodo sed turpis. Phasellus tristique lorem sit
								amet tellus dignissim hendrerit. In hac habitasse platea
								dictumst. Sed vehicula volutpat varius elit. consectetur
								adipiscing elit.</p>
						</div></li>
					<li>
					<img src="<%=request.getContextPath()%>/resources/images/bnr1.jpg"/>
					<!-- <img src="/TourFrancia/WebContent/resources/images/bnr1.jpg" alt=""> -->
						<div class="banner-info">
							<h3>Sed ultricies elementum.</h3>
							<p>Lorem Interdum et malesuada fames ac ante ipsum primis in
								faucibus. Donec a odio quam. Aenean ipsum arcu, luctus vel
								ultricies ut, commodo sed turpis. Phasellus tristique lorem sit
								amet tellus dignissim hendrerit. In hac habitasse platea
								dictumst. Sed vehicula volutpat varius elit. consectetur
								adipiscing elit.</p>
						</div></li>
				</ul>
			</div>
		</div>
		<!---->

		<!---start-content----->
		<div class="banner-bottom-grids">
			<div class="container">
				<div class="col-md-6 banner-text-info clr1">
					<i class="icon1"></i>
					<div class="bnr-text">
						<h3>CHAMPIONS LEAGUE</h3>
						<p>Vestibulum malesuada nisi sit amet justo ullamcorper, non
							convallis justo consequat Integer et urna bibendum elit accumsan
							interdum.</p>
					</div>
				</div>
				<div class="col-md-6 banner-text-info clr2">
					<i class="icon2"></i>
					<div class="bnr-text">
						<h3>NEWS - EVENTS</h3>
						<p>Vestibulum malesuada nisi sit amet justo ullamcorper, non
							convallis justo consequat Integer et urna bibendum elit accumsan
							interdum.</p>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="col-md-6 banner-text-info clr3 btm">
					<i class="icon3"></i>
					<div class="bnr-text">
						<h3>TRAINING</h3>
						<p>Vestibulum malesuada nisi sit amet justo ullamcorper, non
							convallis justo consequat Integer et urna bibendum elit accumsan
							interdum.</p>
					</div>
				</div>
				<div class="col-md-6 banner-text-info clr4 btm">
					<i class="icon4"></i>
					<div class="bnr-text">
						<h3>FINAL TOURNAMENT</h3>
						<p>Vestibulum malesuada nisi sit amet justo ullamcorper, non
							convallis justo consequat Integer et urna bibendum elit accumsan
							interdum.</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //banner -->

	<!-- content -->
	<div class="content">
		<div class="container">
			<div class="content-grids">
				<div class="col-md-4 content-grid1">
					<img src="/resources/images/c1.jpg" alt="" />
					<h3>Champion's League</h3>
					<p>Letraset sheets containing Lorem Ipsum passages, and more
						recently with desktop publishing software like Aldus Letraset
						sheets containing Lorem Ipsum passages, and more recently with
						desktop publishing software like Aldus PageMaker.</p>
					<a href="#">Read More..</a>
				</div>
				<div class="col-md-4 content-grid1">
					<img src="/resources/images/c2.jpg" alt="" />
					<h3>Women's Cup</h3>
					<p>Letraset sheets containing Lorem Ipsum passages, and more
						recently with desktop publishing software like Aldus Letraset
						sheets containing Lorem Ipsum passages, and more recently with
						desktop publishing software like Aldus PageMaker.</p>
					<a href="#">Read More..</a>
				</div>
				<div class="col-md-4 content-grid1">
					<img src="/resources/images/c3.jpg" alt="" />
					<h3>Final Tournment</h3>
					<p>Letraset sheets containing Lorem Ipsum passages, and more
						recently with desktop publishing software like Aldus Letraset
						sheets containing Lorem Ipsum passages, and more recently with
						desktop publishing software like Aldus PageMaker.</p>
					<a href="#">Read More..</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--- //content--->
	<!-- content-bottom -->
	<div class="content-info">
		<div class="container">
			<div class="content-bottom-grids">
				<div class="col-md-4 popular">
					<h3>POPULAR TAGS</h3>
					<ul>
						<li><a href="#">Ut vehicula nisl ut purus tempus aliquet.</a></li>
						<li><a href="#">Nullam a risus pharetra nisi commodo
								auctor.</a></li>
						<li><a href="#">Proin venenatis velit a fringilla rutrum.</a></li>
						<li><a href="#">Nunc facilisis dolor ac suscipit
								volutpat.</a></li>
						<li><a href="#">Cras tempor justo ac mauris laoreet lacus
								efficitur.</a></li>
						<li><a href="#">Sed tincidunt enim ac elit tempor erat
								consequat.</a></li>
						<li><a href="#">Proin venenatis velit a fringilla rutrum.</a></li>
						<li><a href="#"> Aliquam vulputate mi vestibulum mauris
								ultrices.</a></li>
					</ul>
				</div>
				<div class="col-md-4 welcome-pic">
					<h3>ABOUT</h3>
					<h4>Morbi sed arcu mollis, elementum erat venenatis, tincidunt
						tellus.</h4>
					<img src="/resources/images/cnt.ab.jpg" alt="" />
					<p>Aenean ut condimentum magna, mattis pretium massa. Sed
						sollicitudin ullamcorper auctor. Duis vestibulum velit id augue
						pulvinar egestas. Morbi sed orci auctor, feugiat felis at,
						fermentum magna. In ac egestas lectus.</p>
				</div>
				<div class="col-md-4 coach">
					<h3>OUR COACHES</h3>
					<div class="coch-grid chr">
						<div class="coach-pic">
							<img src="/resources/images/ch1.jpg" alt="" />
						</div>
						<div class="coach-pic-info">
							<h4>
								<a href="#">Phasellus at Tellus</a>
							</h4>
							<h5>Aenean vestibulum</h5>
							<p>Donec ornare massa at velit fringilla, condimentum magna
								ornare tincidunt nulla dignissim.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="coch-grid">
						<div class="coach-pic">
							<img src="/resources/images/ch2.jpg" alt="" />
						</div>
						<div class="coach-pic-info">
							<h4>
								<a href="#">Phasellus at Tellus</a>
							</h4>
							<h5>Aenean vestibulum</h5>
							<p>Donec ornare massa at velit fringilla, condimentum magna
								ornare tincidunt nulla dignissim.</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //content-bottom -->
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="copywrite">
				<p>
					© 2015 Soccer. All rights reserved | Design by <a
						href="http://w3layouts.com">W3layouts</a>
				</p>
			</div>
			<div class="footer-menu">
				<ul>
					<li><a href="index.html">HOME</a></li>
					<li><a href="index.html">ABOUT US</a></li>
					<li><a href="index.html">GALERIA</a></li>
					<li><a href="index.html">LA CARRERA</a></li>
					<li><a href="index.html">NOTICIAS</a></li>
					<li><a href="index.html">CONTACTO</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //footer -->
</body>
</html>