<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.css"></link>
</head>
<body>

	<div class="container">

		<table class="table">

			<thead>
				<tr>
					<td>Name</td>
					<td>Photo</td>
					<td>Score</td>
					<td>Character Name</td>
					<td>Photo</td>

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