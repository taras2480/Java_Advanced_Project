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
<meta name="description" content="">
<meta name="author" content="">

<title>Log in with your account</title>

<link type="text/css" href="login.css" rel="stylesheet">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>

</head>

<body>


	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">

						<form id="login-form" method="POST" action="${contextPath}/login"
							class="form-signin form">


							<div class="form-group ${error != null ? 'has-error' : ''}">
								<span>${message}</span> <input id="username" name="email"
									type="text" class="form-control" placeholder="<spring:message code='login.email'/>"
									autofocus="true" />
							</div>


							<div class="form-group ${error != null ? 'has-error' : ''}">

								<input id="password" name="password" type="password"
									class="form-control" placeholder="<spring:message code='login.password'/>" /> <span>${error}</span>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</div>

							<div class="form-group">
								<button class="btn btn-lg btn-primary btn-block btn-info btn-md"
									type="submit"><spring:message code='login.signin'/></button>
							</div>

							<div id="register-link" class="text-right form-group">
								<h4 class="text-center">
									<a href="${contextPath}/registration" class="text-info"><spring:message
									code='login.create_account' /></a>
								</h4>
							</div>


						</form>
						<div>
							<fieldset>
								<label><spring:message code="login.choose_language" /></label>
								<select id="locales">
									<option value="en"><spring:message
											code='login.english' /></option>
									<option value="ua"><spring:message
											code='login.ukrainian' /></option>

								</select>
							</fieldset>
						</div>
						


					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>