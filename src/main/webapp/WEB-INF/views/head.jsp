<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<div class="row p-2 bg-spring-color color-fff">
	<div class="col-6 mb-5 ">
		<a href="${pageContext.request.contextPath}">Log Spring MVC</a>
	</div>
	<div class="col-6">
		<nav class="navbar navbar-light bg-spring-color-dark justify-content-between">
			<a class="nav-item nav-link" href="${pageContext.request.contextPath}/pacote/lista">Pacotes</a>
			<a class="nav-item nav-link" href="${pageContext.request.contextPath}/pacote/form">Cadastrar pacotes</a>
			<a class="nav-item nav-link" href="${pageContext.request.contextPath}/log/lista">Log</a>
			<a class="nav-item nav-link" href="${pageContext.request.contextPath}/log/form">Cadastrar log</a>
		</nav>
	</div>
</div>