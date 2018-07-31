<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<jsp:include page="common/header.jsp" />
</head>
<body>
	<div class="container">
		<h3>User Login</h3>
		<c:if test="${err!=null}">
			<div class="form-group has-error has-feedback">
				<label class="control-label" for="inputWarning1">${err}</label>
			</div>
		</c:if>
		<c:if test="${param.act eq 'lo'}">
			<div class="form-group has-success has-feedback">
				<label class="control-label" for="inputWarning1">Logout Successfully! Thanks for using contact application</label>
			</div>
		</c:if>
		<c:if test="${param.act eq 'reg'}">
			<div class="form-group has-success has-feedback">
				<label class="control-label" for="inputWarning1">User Registration Successfully! Please login</label>
			</div>
		</c:if>
		<spring:url var="url_login" value="/login" />
		<spring:url value="/reg_form" var="url_reg" />
		<form:form action="login" modelAttribute="command" method="post">
			<div class="form-group">
				<label for="loginName">Username</label>
				<form:input path="loginName" class="form-control" id="loginName"
					placeholder="Username" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<form:password path="password" class="form-control" id="password"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Login</button>
					<a href="${url_reg}" class="btn btn-link">New User Registration</a>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="common/footer.jsp" />
</body>
</html>