<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disney Heroes & Villains - Meet The Other Faces</title>
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/litera/bootstrap.min.css">
			<style type="text/css">
				
				.page-header {
					padding-top: 50px;
					padding-bottom: 50px;
					text-align: center;
				}
				
				#character-picture {
					border-radius: 50px;
				}
				
			</style>
	</head>
	<body>
	
		
		<nav class="navbar navbar-expand-lg navbar-light site-header bg-light sticky-top py-1">
				<div class="container">
					<a class="navbar-brand" href="/">H&V</a>
					<div>
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><a class="nav-link" href="aboutus">About</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Legend</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Meet The Others</a></li>
						</ul>
					</div>
				</div>
		</nav>
		
		<div class="container">
	
			<table class="table">
	
				<thead>
					<tr class="table-active">
						<th scope="col">Name</th>
						<th scope="col">Photo</th>
						<th scope="col">Score</th>
						<th scope="col">Character Name</th>
						<th scope="col">Photo</th>
	
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="c" items="${model}">
	
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