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
		<h3>Contact Form</h3>
		<c:if test="${err!=null}">
			<div class="form-group has-error has-feedback">
				<label class="control-label" for="inputWarning1">${err}</label>
			</div>
		</c:if>
		<spring:url var="url_csave" value="/user/save_contact" />
		<form:form action="${url_csave}" modelAttribute="command"
			method="post">
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="name" class="form-control" id="name"
					placeholder="Name" />
			</div>
			<div class="form-group">
				<label for="phone">Phone</label>
				<form:input path="phone" class="form-control" id="phone"
					placeholder="Phone" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" class="form-control" id="email"
					placeholder="email" />
			</div>
			<div class="form-group">
				<label for="address">Address</label>
				<form:input path="address" class="form-control" id="address"
					placeholder="Address" />
			</div>
			<div class="form-group">
				<label for="remark">Remark</label>
				<form:input path="remark" class="form-control" id="remark"
					placeholder="remark" />
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="common/footer.jsp" />
</body>
</html>