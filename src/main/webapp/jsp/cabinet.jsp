<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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
<body>
	<div class="container">


		<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
			style="display: none" id="mySidebar">

			<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">
				<spring:message code='login.hide_menu' />
				&times;
			</button>
			<a href="/home" class="w3-bar-item w3-button"><spring:message
					code='home.home' /></a>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="create-faculty" class="w3-bar-item w3-button"><spring:message
						code='home.create_faculty' /></a>
			</security:authorize>


			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/notabilities" class="w3-bar-item w3-button"><spring:message
						code='home.notability' /></a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_USER')">
				<a href="cabinet" class="w3-bar-item w3-button"><spring:message
						code='home.cabinet' /></a>
			</security:authorize>
		</div>

		<div id="main">

			<div class="w3-teal">
				<button id="openNav" class="w3-button w3-teal w3-xlarge"
					onclick="w3_open()">
					&#9776;
					<spring:message code='home.menu' />
				</button>
				<div class="w3-container">
					<h1>
						<spring:message code='login.registration_entrant' />
					</h1>
				</div>
			</div>


			<div class="w3-container">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h2>
						<spring:message code='home.welcome' />
						${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()"><spring:message
								code='home.logout' /></a>
					</h2>

				</c:if>


				<table>
					<thead>
						<tr>
							<th><spring:message code='notability.documents' /></th>
							<th><spring:message code='notability.first_name' /></th>
							<th><spring:message code='notability.last_name' /></th>
							<th><spring:message code='login.email' /></th>
							<th><spring:message code='notability.birthday' /></th>
							<th><spring:message code='notability.faculty_name' /></th>
							<th><spring:message code='notability.max_allowed_students' /></th>
							<th><spring:message code='notability.subjects_raitings' /></th>
							<th style="color: blue;"><spring:message
									code='notability.summary_raiting' /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${notabilities}" var="currentNotabilities">
							<tr>
								<td rowspan="2"><img
									src="data:image/png;base64,${currentNotabilities.encodedEntrantImage}"
									width="60" /></td>
								<td rowspan="2">${currentNotabilities.user.firstName}</td>
								<td rowspan="2">${currentNotabilities.user.lastName}</td>
								<td rowspan="2">${currentNotabilities.user.email}</td>
								<td rowspan="2">${currentNotabilities.user.birthday}</td>
								<td rowspan="2">${currentNotabilities.faculty.nameFaculty}</td>
								<td rowspan="2">${currentNotabilities.faculty.amountOfStudents}</td>


								<c:forEach items="${currentNotabilities.faculty.subjects}"
									var="currentSubject">
									<td>${currentSubject}</td>
								</c:forEach>
							<tr>
								<c:forEach items="${currentNotabilities.ratings}"
									var="currentRatings">
									<td>${currentRatings}</td>
								</c:forEach>

								<td style="color: blue; font-weight: bold;">${currentNotabilities.sumRating}</td>



							</tr>
							<tr>
								<td><input type="hidden" name="userId"
									value="${notability.user.id}" /></td>

							</tr>


						</c:forEach>
					</tbody>
				</table>

			</div>

		</div>

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
			}
		</script>



	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>