<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>University-x</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

	<div class="container">


		<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
			style="display: none" id="mySidebar">

			<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Hide menu
				&times;</button>
			<a href="/home" class="w3-bar-item w3-button">Home</a>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="create-faculty" class="w3-bar-item w3-button">Create faculty</a>
			</security:authorize>


			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/notabilities" class="w3-bar-item w3-button">Notability</a>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_USER')">
				<a href="cabinet" class="w3-bar-item w3-button">Cabinet</a>
			</security:authorize>

			<!-- <a href="#"
				class="w3-bar-item w3-button">Link 3</a> -->
		</div>

		<div id="main">

			<div class="w3-teal">
				<button id="openNav" class="w3-button w3-teal w3-xlarge"
					onclick="w3_open()">&#9776; Menu</button>
				<div class="w3-container">
					<h1>Registration entrant</h1>
				</div>
			</div>


			<div class="w3-container">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>

				</c:if>

				<form:form method="POST" action="${contextPath}/addFaculty"
					 modelAttribute="faculty">
					<table>
						<tr>
							<td>Name</td>
							<td><input type="text" name="nameFaculty" /></td>
						</tr>
						<tr>
							<td>Max allowed entrants</td>
							<td><input type="number" name="amountOfStudents" /></td>
						</tr>
						
						<tr>
							<td>Choose subjects: <br><c:if test="${not empty subjects}">
									<c:forEach items="${subjects}" var="currentSubject">
										<form:checkbox path="subjects" value="${currentSubject}" />${currentSubject}<br>
									</c:forEach>
								</c:if>
							</td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>

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

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</div>
</body>
</html>