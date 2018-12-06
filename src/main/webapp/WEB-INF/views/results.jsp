<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your analyzed results</title>
<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.css"></link>
</head>
<body>

	<div class="container">
		<div class = "row">
			<div class = "col-md">
			
			</div>
			<div class = "col-md">
				<h1>Emotion Score Breakdown</h1>
			</div>
			<div class = "col-md">
			
			</div>
		</div>
		<div class = "row">
			<div class = "col-md">
			
			</div>
			<div class = "col-md">
				<canvas id = "doughnutChart" width="600" height="600">
					<script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/compiled-4.5.15.min.js"></script>
				</canvas>
			</div>
			<div class = "col-md">
			
			</div>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<td>Contempt</td>
					<td>Surprise</td>
					<td>Happiness</td>
					<td>Neutral</td>
					<td>Sadness</td>
					<td>Disgust</td>
					<td>Anger</td>
					<td>Fear</td>
					
				<tr>
			</thead>
			<tbody>


				<tr>
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
		    type: 'doughnut',
		    data: {
		      labels: ["Contempt", "Surprise", "Happiness", "Neutral", "Sadness", "Disgust", "Anger", "Fear"],
		      datasets: [{
		        data: [contempt, surprise, happiness, neutral, sadness, disgust, anger, fear],
		        backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360", "#8e1173", "#ff6100", "#00c7ff"],
		        hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774", "#c13ea5", "#ff853a", "#6adcfc"]
		      }]
		    },
		    options: {
		      responsive: true
		    }
		  });

	</script>
	
		
		<table>
		<thead>
		<tr>
		<td>Character</td>
		<td>Picture</td>
		<td>Movie</td>
		</tr>
		
		</thead>
	<tbody>
	<tr>
		<td>${ch.name}</td>
		<td><img src = "${ch.imgUrl}" width = "200px" height = "200px"></td>
		<td>${ch.movie}<td>
		
		</tr>
	</tbody>
		</table>
		
		<form action="addUser">
		<input type="hidden" name="username" value="${user}">
		<input type="hidden" name="file" value="${url}">
		<input type="hidden" name="score" value="${score}">
		<input type="hidden" name = "score2" value="${ch.characterID}">
		<input class="btn btn-primary" type="Submit" value="Save Results">
		
		
		</form>
		
		${saved}
		
		
		<a href = "top10">See the last ten results</a>
	

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