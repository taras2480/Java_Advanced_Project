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

					<div style="text-align:center; color:#8593E2"><h3>
						<spring:message code='home.welcome' />
						${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()"><spring:message
								code='home.logout' /></a>
					</h3></div>

				</c:if>

				<c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculty">

						<div class="w3-card-4 "
							style="width: 25%; margin: 1%; float: left; border: 1px solid green; background-color: #6D675A;">
							<div
								style="border: 1px solid blue; color: #FFDD00;text-align:center;">
								<h2>${currentFaculty.nameFaculty}</h2>
							</div>

							<div class="w3-container w3-center"
								style="background-color: #ced4da;">

								<h4>Max allowed Students:
									${currentFaculty.amountOfStudents}</h4>
								<h4>
									Subjects for admission :<br>
								</h4>
								<c:forEach items="${currentFaculty.subjects}"
									var="currentSubject">
									<p>${currentSubject}</p>
								</c:forEach>

							</div>

							<div
								style="float: left; padding-left: 20px; background-color: #3AE2CE; border: 1px solid blue; padding-right: 10px">
								<a
									href="enrollmenToFaculty?currentId=${currentFaculty.id}&currentUserEmail=${pageContext.request.userPrincipal.name}"
									class="btn btn-primary"><spring:message
										code='home.choose_this_faculty' /></a>
							</div>
							<div
								style="padding-left: 180px; background-color: #3AE2CE; border: 1px solid blue">
								<a
									href="showHappyStudents?currentFacultyId=${currentFaculty.id}"><spring:message
										code='home.future_students' /></a>
							</div>




						</div>

					</c:forEach>
				</c:if>

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