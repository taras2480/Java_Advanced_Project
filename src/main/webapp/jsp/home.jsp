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
<body>
	<div class="container">


		<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
			style="display: none" id="mySidebar">

			<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close
				&times;</button>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="create-faculty" class="w3-bar-item w3-button">Create
				faculty</a> <a href="/notabilities" class="w3-bar-item w3-button">Notability</a>
			<a href="/showHappyStudents" class="w3-bar-item w3-button">Future
				Students</a>
		</div>

		<div id="main">

			<div class="w3-teal">
				<button id="openNav" class="w3-button w3-teal w3-xlarge"
					onclick="w3_open()">&#9776; Create faculty</button>
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

				<c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculty">

						<div class="w3-card-4" style="width: 20%; margin: 2%">

							<div class="w3-container w3-center">
								<h3>${currentFaculty.nameFaculty}</h3>
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

							<a
								href="enrollmenToFaculty?currentId=${currentFaculty.id}&currentUserEmail=${pageContext.request.userPrincipal.name}"
								class="btn btn-primary">Choose this faculty</a>
								<a href="showHappyStudents?currentFacultyId=${currentFaculty.id}">Show Happy Students</a>




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