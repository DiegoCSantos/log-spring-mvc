<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
 
<tags:template titulo="Cadastrar log">
<h3>${sucesso}</h3>
	<form action="${empty log?'':'alterar' }" method="POST" >
		
		<input type="hidden" name="id" readonly value="${log.id}">
		<div class="form-group row">
		    <label for="pacote.codigo"  class="col-2 col-form-label">Pacote</label>
		    	<div class="col-10">
			    	<select  name="pacote.codigo" class="form-control">
						<option value="" >Escolha o pacote</option>
						<c:forEach items="${pacotes}" var="pacote">
							<option value="${pacote.codigo}" ${not empty codigoPacote && codigoPacote == pacote.codigo  ? 'selected':'' }>${pacote.codigo} </option>
						</c:forEach>
					</select>
				</div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="mensagem"  class="col-2 col-form-label" >Mensagem</label>
		    <div class="col-10">
				<input type="text"  class="form-control" name="mensagem" value="${log.mensagem}" />
			</div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="data"  class="col-2 col-form-label">Mensagem</label>
		    <div class="col-10">
				<input type="text"  class="form-control" name="data" placeholder="aaa/mm/dd" value="${log.data}" />
			</div>
		 </div>
		   
		   <button type="submit" class="btn btn-primary">${empty log?'Cadastrar': 'Alterar'}</button>
		   <button type="reset" class="btn btn-primary" > Limpar </button>
	</form>
	
</tags:template>