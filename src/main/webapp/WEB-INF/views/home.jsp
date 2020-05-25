<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
 
<tags:template titulo="Log spring mvc">
<c:if test="${not empty erro}">
	<div class="alert alert-danger" role="alert">
  		${erro}
	</div>
</c:if>
<div class="row text-center mt-5">
	<div class="col-10">
		<form action="" method="GET">
		<label for="search" class="">Insira seu código de rastreamento</label>
			<div class="input-group mb-3">
					<input class="form-control" type="text" name="search">
					<div class="input-group-append">
				    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Buscar</button>
				  </div>
			</div>
		</form>
	
	</div>
</div>
<div class="row text-center">
	<div class="col-10">
		<ul class="list-group">
			<c:forEach items="${logs}" var="log" varStatus="index">
				<li class="list-group-item ${index.count mod 2 == 0? 'list-group-item-secondary' : 'list-group-item-dark'}">
					${log.data} ${log.mensagem} 
				</li>
			</c:forEach>
		</ul>	
	</div>
</div>
</tags:template>