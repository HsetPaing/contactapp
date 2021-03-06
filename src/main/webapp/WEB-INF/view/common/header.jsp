<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link
	href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />"
	rel="stylesheet">
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${url_index}">Project name</a>
			</div>
			<spring:url value="/logout" var="url_logout"/>
			<spring:url value="/reg_form" var="url_reg" />
			<spring:url value="/index" var="url_index" />
			
			<div id="navbar" class="collapse navbar-collapse">
				<c:if test="${sessionScope.userId==null}">
					<%-- User is not yet logged in : guset menu --%>					
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Help</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${url_index}">Login</a></li>
						<li><a href="${url_reg}">Register</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
					<%-- Admin is logged in : Admin menu --%>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">UserList</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${url_logout}">Logout</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
					<%-- General user is logged in : user menu --%>
					<spring:url var="url_uhome" value="/user/dashboard" />
					<spring:url var="url_cform" value="/user/contact_form" />
					<ul class="nav navbar-nav">
						<li class="active"><a href="${url_uhome}">Home</a></li>
						<li><a href="${url_cform}">Add Contact</a></li>
						<li><a href="#">Contact List</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${url_logout}">Logout</a></li>
					</ul>
				</c:if>
			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- /.navbar -->