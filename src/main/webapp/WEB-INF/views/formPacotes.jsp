<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
 
 <tags:template titulo="Cadastrar pacote">
 
 	<h3>${sucesso}</h3>
	<form action="${not empty pacote?'alterar':''}" method="POST" >
	
		<div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Pacote</label>
		    	<div class="col-10">
		    		<c:choose>
						<c:when test="${not empty pacote}">
							<input type="text" class="form-control" name="codigo" readonly value ="${pacote.codigo}">
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" name="codigo" value ="">
						</c:otherwise>
					</c:choose>
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Destino</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="destino" value ="${not empty pacote? pacote.destino : ''}">
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Origem</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="origem" value ="${not empty pacote? pacote.origem : ''}">
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Destinatario</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="destinatario" value ="${not empty pacote? pacote.destinatario : ''}">
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Remetente</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="remetente" value ="${not empty pacote? pacote.remetente : ''}">
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Doc. Destinatario</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="docDestinatario" value ="${not empty pacote? pacote.docDestinatario : ''}">
				</div>
		  </div>
		  <div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Doc. Remetente</label>
		    	<div class="col-10">
					<input type="text" class="form-control" name="docRemetente" value ="${not empty pacote? pacote.docRemetente : ''}">
				</div>
		  </div>
			<button type="submit" class="btn btn-primary">${empty pacote? 'Enviar' : 'Alterar'}</button>
			<button type="reset" class="btn btn-primary">limpar</button>
	</form>
 
 
 </tags:template>