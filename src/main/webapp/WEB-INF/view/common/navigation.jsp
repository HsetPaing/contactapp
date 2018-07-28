<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<c:if test="${sessionScope.userId==null}">
				<%-- User is not yet logged in : guset menu --%>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Login</a></li>
					<li><a href="#">Register</a></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.userId != null && sessionScope.role ==1}">
				<%-- Admin is logged in : Admin menu --%>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">UserList</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Logout</a></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.userId!=null && sessionScope.role ==2}">
				<%-- General user is logged in : user menu --%>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Add Contact</a></li>
					<li><a href="#">Contact List</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Logout</a></li>
				</ul>
			</c:if>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</nav>