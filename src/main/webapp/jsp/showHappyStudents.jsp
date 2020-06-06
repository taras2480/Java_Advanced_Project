<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>University-x</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<style>
table {
	margin-left: 10%;
}

table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
}

th, td, h2 {
	text-align: center;
}
</style>
</head>

<body>

	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none" id="mySidebar">

		<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Hide menu</button>
		<a href="/home" class="w3-bar-item w3-button">Home</a> <a
			href="create-faculty" class="w3-bar-item w3-button">Create faculty</a> <a href="/notabilities" class="w3-bar-item w3-button">Notability</a>
	</div>

	
	<h2>Rating of faculty with name ${faculty.nameFaculty}</h2>

	<c:if test="${not empty happyFutureStudentss}">

		<table style="width: 90%">
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th colspan="30">Ratings</th>
				<th style="color: blue; font-weight: bold;">Sum Rating</th>
				<th>Approved or not</th>
				

			</tr>
			<c:forEach items="${happyFutureStudentss}" var="currentStudents"
				varStatus="status">
				<tr>
					<td rowspan="2">${users[status.index].firstName}</td>
					<td rowspan="2">${users[status.index].lastName}</td>

					<c:forEach items="${faculty.subjects}" var="currentSubject">
						<td colspan="6">${currentSubject}</td>
					</c:forEach>

					


				</tr>
				<tr>
					<c:forEach items="${currentStudents.statementRatings}"
						var="currentRatings">
						<td colspan="6">${currentRatings}</td>
					</c:forEach>
					<td style="color: blue; font-weight: bold;">${currentStudents.summaryRaiting}</td>
					<td rowspan="2">${accepting[status.index]}</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>
	<script>
			function w3_open() {
				document.getElementById("main").style.marginLeft = "25%";
				document.getElementById("mySidebar").style.width = "25%";
				document.getElementById("mySidebar").style.display = "block";
				document.getElementById("openNav").style.display = 'none';
			}
			function w3_close() {
				document.getElementById("main").style.marginLeft = "0%";
				document.getElementById("mySidebar").style.display = "none";
				document.getElementById("openNav").style.display = "inline-block";
			}</script>
			<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>