<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains</title>
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
			
			#row2 {
				padding-top: 30px;
			}
			
			#call-to-action {
				padding-bottom: 20px;
			}
			
			#redletter {
				color: #fc0000;
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
							<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
							About
							<span class="caret"></span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="aboutus">About The Team</a>
								<a class="dropdown-item" href="aboutproject">About The Project</a>
							</div>
						</li>
						
						<li class="nav-item"><a class="nav-link" href="legends">Legend</a></li>
						<li class="nav-item"><a class="nav-link" href="allusers">Meet The Others</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container">
			
			<div class="page-header">
			
				<p class="lead">Ever wanted to know what Disney character you're most like?</p>
				<h1>Welcome to Disney</h1>
				<h1>Heroes And Villains</h1>
				<h3>Emotional Analysis Generator</h3>
			
			</div>
			
			<div class="header-graphic"></div>
			
			<div class="row" id="row1">
				
				<div class="col-md">
				
					<div id="call-to-action">
						
						<h3>Step 1: Get your face <span id="redletter">read.</span></h3>
					</div>
					
					<ul>
						<li>Type your name in the form below.</li>
						<li>Upload your picture into the TinyPic app.</li>
						<li>Copy and paste your picture URL into the form.</li>
						<li>Press submit and get analyzed.<br>Don't worry, it's painless.</li>
					</ul>
					
				    <form class="form-group" action = "getresults">
				        <input class="form-control" type = "text" name = "username" placeholder = "Enter your name" required >
				        <br>
				        <input class="form-control" type = "text" name = "file" placeholder = "Enter your picture's URL" required>
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
			
			<div id="row2" class="row">
	
				<table class="table">
		
					<thead>
						<tr class="table-active">
							<th scope="col">Name</th>
							<th scope="col">User Photo</th>
							<th scope="col">Score</th>
							<th scope="col">Character Name</th>
							<th scope="col">Photo</th>
		
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="c" items="${ten}">
		
							<tr>
								<td>${c.name}</td>
								<td><img src="${c.imgUrl}" width="200px" height="200px"></td>
								<td>${c.overallScore}</td>
								<td>${c.characters.name}</td>
								<td><img src="${c.characters.imgUrl}" width="200px" height="200px"></td>
							</tr>
		
						</c:forEach>
		
					</tbody>
		
				</table>
			
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