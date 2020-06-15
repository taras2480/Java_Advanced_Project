<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Registration</title>
<link type="text/css" href="registration.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%-- <link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
</head>

<body>

	<div class="container register-form">
		<div class="form">
		<div class="form-content">

			<div class="row">
				<div class="col-md-8 form-group" >
					

						<form:form method="POST" modelAttribute="userForm"
							class="form-signin ">
							<h2 class="note"><spring:message code='registration.title'/></h2>

							<spring:bind path="firstName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="firstName" class="form-control"
										placeholder="First Name/Прізвище" autofocus="true"/>
									<form:errors path="firstName"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="lastName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="lastName" class="form-control"
										placeholder="Last Name/Ім'я" autofocus="true"/>
									<form:errors path="lastName"></form:errors>
								</div>
							</spring:bind>


							<spring:bind path="email">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="email" class="form-control"
										placeholder="Email/Ел.Пошта" autofocus="true"/>
									<form:errors path="email"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="password"
										class="form-control" placeholder="Password/Пароль"/>
									<form:errors path="password"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="confirmPassword">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="confirmPassword"
										class="form-control" placeholder="Confirm password/Підтвердіть пароль"/>
									<form:errors path="confirmPassword"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="birthday">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="date" path="birthday" class="form-control"
										/>
									<form:errors path="birthday"></form:errors>
								</div>
							</spring:bind>


							<button class="btnSubmit" type="submit"><spring:message code='registration.submit'/></button>
						</form:form>

					
				</div>
			</div>
			</div>
		</div>
	</div>
	
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>