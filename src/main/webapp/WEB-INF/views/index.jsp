<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/litera/bootstrap.min.css">
		<style type="text/css">
			.page-header {
				padding-top: 150px;
				padding-bottom: 150px;
				text-align: center;
			}
			
			h1 {
				font-size: 4em;
				letter-spacing: -2px;
			}
			
			h2 {
				text-align: center;
			}
			
			#redletter {
				color: #fc0000;
			}
			#carouselfaces img {
				max-height: 600px;
				
			}
		</style>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-light site-header bg-light sticky-top py-1">
			<div class="container">
				<a class="navbar-brand" href="#">H&V</a>
				<div>
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link" href="#">Legend</a></li>
						<li class="nav-item"><a class="nav-link" href="topten">Meet The Others</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container">
			
			<div class="page-header">
			
				<h1>Welcome to Disney</h1>
				<h1>Heroes And Villains</h1>
			
				<!-- <div id="carouselfaces" class="carousel slide" data-ride="carousel">
		  			<div class="carousel-inner">
			    		<div class="carousel-item active">
			      			<img class="d-block w-100" src="http://i63.tinypic.com/6ymtmx.jpg" alt="First slide">
			    		</div>
			    		<div class="carousel-item">
			      			<img class="d-block w-100" src="http://i68.tinypic.com/2hxsh3.jpg" alt="Second slide">
			    		</div>
			    		<div class="carousel-item">
			      			<img class="d-block w-100" src="http://i67.tinypic.com/2wg6c76.jpg" alt="Third slide">
			    		</div>
			    		<div class="carousel-item">
			      			<img class="d-block w-100" src="http://i67.tinypic.com/29e57j7.jpg" alt="Third slide">
			    		</div>
			    		<div class="carousel-item">
			      			<img class="d-block w-100" src="http://i66.tinypic.com/97le1k.jpg" alt="Third slide">
			    		</div>
		  			</div>
				</div> -->
			</div>
			
			<div class="row">
				
				<div class="col-md">
				
					<h2>Get your face</h2>
					<h2 id="redletter">read.</h2>
					<ul>
						<li>Type your name in the form below.</li>
						<li>Upload your picture into the TinyPic app.</li>
						<li>Copy and paste your picture URL into the form.</li>
						<li>Press submit and get analyzed.<br>Don't worry, it's painless.</li>
					</ul>
					
				    <form class="form-group" action = "getresults">
				        <input class="form-control" type = "text" name = "username" placeholder = "Enter your name">
				        <br>
				        <input class="form-control" type = "text" name = "file" placeholder = "Enter your picture's URL">
				        <br>
				        <input id="button" class="btn btn-secondary" type = "submit" value = "Upload File">
				    </form>
					
				</div>
				
				<div class="col-md">
				
					<script type="text/javascript">
						tinypic_layout = 'wide';
						tinypic_type = 'both';
						tinypic_links = 'url';
						tinypic_language = 'en';
						tinypic_search = 'false';
						tinypic_autoload = true;
					</script>
					<script src="http://plugin.tinypic.com/j/plugin.js" type="text/javascript"></script>
				
				</div>
				
			</div>

		
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>