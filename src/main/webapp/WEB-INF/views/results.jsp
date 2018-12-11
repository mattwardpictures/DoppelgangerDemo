<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains - Your Results</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/litera/bootstrap.min.css">
		<style type="text/css">
			.page-header {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
			#character-picture {
				border-radius: 50px;
				border: 5px solid gray;
			}
			
			#footer {
				padding-top: 50px;
				padding-bottom: 50px;
				text-align: center;
			}
			
			.card {
				margin-top: 20px;
			}
			
			.card-text {
				font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
			}
			
		</style>
	</head>

	<body>
	
		<nav
			class="navbar navbar-expand-lg navbar-light site-header bg-light sticky-top py-1">
			<div class="container">
				<a class="navbar-brand" href="/">H&V</a>
				<div>
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown show"><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
							aria-expanded="true"> About <span class="caret"></span>
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="aboutus">About The Team</a> <a
									class="dropdown-item" href="aboutproject">About The Project</a>
							</div></li>
	
						<li class="nav-item"><a class="nav-link" href="legends">Legend</a></li>
						<li class="nav-item"><a class="nav-link" href="allusers">Meet
								The Others</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="page-header">
	
			<div class="row">
				<div class="col-md"></div>
				<div class="col-md">
					<h1>Emotion Score Breakdown</h1>
				</div>
				<div class="col-md"></div>
			</div>
	
		</div>
	
		<div class="container">
	
			<div class="jumbotron-fluid">
				<div class="row">
					<div class="col-md">
	
						<h3>You're most like...</h3>
						<h1 class="display-3">${ch.name}</h1>
						<br> 
						<img id="character-picture" src="${ch.imgUrl}" width="300px" height="300px">
						<br>
						<div class="card text-white bg-secondary mb-3" style="max-width: 30rem;">
						  <div class="card-header">Personality Traits</div>
						  <div class="card-body">
						    <p class="card-text">${ch.personality}</p>
						  </div>
						</div>
						
					</div>
					
					<div class="col-md">
	
						<canvas id="doughnutChart" width="400" height="400">
								<script type="text/javascript"
								src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/compiled-4.5.15.min.js"></script>
						</canvas>
	
					</div>
				</div>
			</div>
	
			<table class="table table-hover">
	
				<thead>
					<tr>
						<th scope="col">Contempt</th>
						<th scope="col">Surprise</th>
						<th scope="col">Happiness</th>
						<th scope="col">Neutral</th>
						<th scope="col">Sadness</th>
						<th scope="col">Disgust</th>
						<th scope="col">Anger</th>
						<th scope="col">Fear</th>
					<tr>
				</thead>
	
				<tbody>
	
					<tr class="table-active">
	
						<td id="contempt">${results.contempt}</td>
	
						<td id="surprise">${results.surprise}</td>
	
						<td id="happiness">${results.happiness}</td>
	
						<td id="neutral">${results.neutral}</td>
	
						<td id="sadness">${results.sadness}</td>
	
						<td id="disgust">${results.disgust}</td>
	
						<td id="anger">${results.anger}</td>
	
						<td id="fear">${results.fear}</td>
	
					</tr>
	
				</tbody>
	
			</table>
	
			<h1>Your score: ${score}</h1>
	
			<br>
	
			<div class="row">
			
				<div class="col-md">
				
				</div>
				
				<div class="col-md" style="text-align:center;">
				
					<form action="addUser">
						<input type="hidden" name="username" value="${user}"> <input
							type="hidden" name="file" value="${url}"> <input
							type="hidden" name="score" value="${score}"> <input
							type="hidden" name="score2" value="${ch.characterID}"> <input
							class="btn btn-primary" type="Submit" value="Save Results">
					</form>
			
					${saved} <br> <a href="allusers" class="btn btn-primary">See all results</a>
				
				
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
		
		
	
		<script>
			//doughnut
			var ctxD = document.getElementById("doughnutChart").getContext('2d');
			var contempt = ${results.contempt};
			var surprise = ${results.surprise};
			var happiness = ${results.happiness};
			var neutral = ${results.neutral};
			var sadness = ${results.sadness};
			var disgust = ${results.disgust};
			var anger = ${results.anger};
			var fear = ${results.fear};
			var myLineChart = new Chart(ctxD, {
				type : 'doughnut',
				data : {
					labels : [ "Contempt", "Surprise", "Happiness", "Neutral",
							"Sadness", "Disgust", "Anger", "Fear" ],
					datasets : [ {
						data : [ contempt, surprise, happiness, neutral, sadness,
								disgust, anger, fear ],
						backgroundColor : [ "#F7464A", "#46BFBD", "#FDB45C",
								"#949FB1", "#4D5360", "#8e1173", "#ff6100",
								"#00c7ff" ],
						hoverBackgroundColor : [ "#FF5A5E", "#5AD3D1", "#FFC870",
								"#A8B3C5", "#616774", "#c13ea5", "#ff853a",
								"#6adcfc" ]
					} ]
				},
				options : {
					responsive : true
				}
			});
		</script>
	
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
			integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
			integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
			crossorigin="anonymous"></script>
			
	</body>
</html>