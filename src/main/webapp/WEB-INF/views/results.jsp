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
<h1>Emotion Score Breakdown</h1>
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
					<td>${results.contempt}</td> 
					
					<td>${results.surprise}</td>
			
					<td>${results.happiness}</td>
			
					<td>${results.neutral}</td>
			
					<td>${results.sadness}</td>
					
					<td>${results.disgust}</td>
					
					<td>${results.anger}</td>
					
					<td>${results.fear}</td>
			

				</tr>
			</tbody>


		</table>
		<h1>Your score: ${score}</h1>
	</div>

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