<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains - Step 2: Quiz</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cyborg/bootstrap.min.css">
		<style type="text/css">
			
			body {
				font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
			}
			
			p.lead {
				letter-spacing: 1px;
			}
			
			.page-header {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
			.page-header h3 {
				font-size: 2em;
				line-height: 2;
			}
			
			.header-graphic {
				min-height: 500px;
				background-image: url("https://images3.alphacoders.com/637/637817.jpg");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center;
			}
			
			h1 {
				font-size: 5em;
				letter-spacing: -2px;
				line-height: 1;
			}
			
			h2, h3 {
				text-align: center;
			}
			
			#row1 {
				padding-top: 30px;
			}
			
			#call-to-action {
				padding-bottom: 20px;
			}
			
			#redletter {
				color: #fc0000;
			}
			#carouselfaces img {
				max-height: 600px;
				
			}
			
			#footer {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
		</style>
	</head>
	
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark site-header bg-dark sticky-top py-1">
			<div class="container">
				<a class="navbar-brand" href="#">H&V</a>
				<div>
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown show">
							<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="/" aria-expanded="true">
							About
							<span class="caret"></span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="aboutus">About The Team</a>
								<a class="dropdown-item" href="aboutproject">About The Project</a>
							</div>
						</li>
						
						<li class="nav-item"><a class="nav-link" href="legends">Legend</a></li>
						<li class="nav-item"><a class="nav-link" href="topten">Meet The Others</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container">
		
			<div class="page-header">
				
				<h2>Step 2: Answer These Questions</h2>
			
			</div>
			
			<div class="row">
				
				<div class="col-md">
					
					<form class="form-group" action="quizresult1">
						<h3>Your birthday is fast approaching, and your idea of attending a big party thrown in your honor is:</h3>
						<ol>
							<li><input type="radio" name="happiness" >I’m stoked, bring on the cake!</li>
							<li><input type="radio" name="surprise" >Uh-oh, panic poops.</li>
							<li><input type="radio" name="neutral" >I stopped counting after my 1st child.</li>
							<li><input type="radio" name="anger" >Who’s paying?</li>
							<li><input type="radio" name="sadness" >I don’t deserve this.</li>
						</ol>
						<input id="button" class="btn btn-secondary" type = "submit" value = "Enter">
					</form>
					
				</div>
				
				<div class="col-md">
				
				</div>
			
			</div>
			
			<div class="row">
				
				<div class="col-md">
					
					<form class="form-group" action="quizresult2">
						<h3>How do you feel before crossing a busy street?</h3>
						<ol>
							<li><input type="radio" name="happiness" >I’m stoked, bring on the cake!</li>
							<li><input type="radio" name="surprise" >Uh-oh, panic poops.</li>
							<li><input type="radio" name="neutral" >I stopped counting after my 1st child.</li>
							<li><input type="radio" name="anger" >Who’s paying?</li>
							<li><input type="radio" name="sadness" >Rex from Toy Story</li>
						</ol>
						<input id="button" class="btn btn-secondary" type = "submit" value = "Enter">
					</form>
					
				</div>
				
				<div class="col-md">
				
				</div>
			
			</div>
			
			<div id="footer" class="row">
				<div class="col-md">
					
				</div>
				<div class="col-md">
					<small>©2018 Heroes & Villains Doppelganger Project.</small>
					<br>
					<small>All Disney characters are ©Disney. All rights reserved.</small>
				</div>
				<div class="col-md">
			
				</div>
			</div>
		
		</div>
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>