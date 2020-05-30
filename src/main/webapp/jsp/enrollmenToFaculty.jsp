<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

			<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close
				&times;</button>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="create-faculty" class="w3-bar-item w3-button">Create
				faculty</a>
			<!-- <a href="#"
				class="w3-bar-item w3-button">Link 3</a> -->
		</div>

		<div id="main">

			<div class="w3-teal">
				<button id="openNav" class="w3-button w3-teal w3-xlarge"
					onclick="w3_open()">&#9776; Create faculty</button>
				<div class="w3-container">
					<h1>Registration</h1>
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

				<form:form method="POST" action="${contextPath}/addPoints"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Added points to subjects</td>

						</tr>
						<c:forEach items="${notability.faculty.subjects}"
							var="currentSubject">
							<tr>
								<td>${currentSubject}</td>
								<td><input type="number" name="ratings" /></td>
							</tr>
						</c:forEach>

						<tr>
							<td>Upload your documents:</td>
							<td><input type="file" name="image" /></td>
						</tr>
						
						<tr>
							<td><input type="hidden" name="facultyId"
								value="${notability.faculty.id}" /></td>
							<td><input type="hidden" name="userEmail"
								value="${notability.user.email}" /></td>
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