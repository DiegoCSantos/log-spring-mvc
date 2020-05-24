<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Log</title>
</head>
<body>
<h3>${sucesso}</h3>
	<form action="${empty log?'':'alterar' }" method="POST" >
		<input type="hidden" name="id" readonly value="${log.id}">
		<table>
			<tr>
				<td>
					Pacote
				</td>
				<td>
					<select  name="pacote.codigo">
						<option value="" >Escolha o pacote</option>
						<c:forEach items="${pacotes}" var="pacote">
							<option value="${pacote.codigo}" ${not empty codigoPacote && codigoPacote == pacote.codigo  ? 'selected':'' }>${pacote.codigo} </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Mensagem
				</td>
				<td>
					<input type="text"  name="mensagem" value="${log.mensagem}" />
				</td>
			</tr>
			<tr>
				<td>
					Data
				</td>
				<td>
					<input type="text"  name="data" placeholder="aaa/mm/dd" value="${log.data}" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="${empty log?'Cadastrar': 'Alterar'}"/>
				</td>
				<td>
					<input type="reset" value="limpar"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>