<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Pacote</title>
</head>
<body>
	<h3>${sucesso}</h3>
	<form action="${not empty pacote?'alterar':''}" method="POST" >
		<table>
			<tr>
				<td>
					Código
				</td>
				<td>
					<c:choose>
						<c:when test="${not empty pacote}">
							<input type="text" name="codigo" readonly value ="${pacote.codigo}">
						</c:when>
						<c:otherwise>
							<input type="text" name="codigo" value ="">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Destino
				</td>
				<td>
					<input type="text" name="destino" value ="${not empty pacote? pacote.destino : ''}">
				</td>
			</tr>
			<tr>
				<td>
					Origem
				</td>
				<td>
					<input type="text" name="origem" value ="${not empty pacote? pacote.origem : ''}">
				</td>
			</tr>
			<tr>
				<td>
					Destinatario
				</td>
				<td>
					<input type="text" name="destinatario" value ="${not empty pacote? pacote.destinatario : ''}">
				</td>
			</tr>
			<tr>
				<td>
					Remetente
				</td>
				<td>
					<input type="text" name="remetente" value ="${not empty pacote? pacote.remetente : ''}">
				</td>
			</tr>
			<tr>
				<td>
					Doc. Destinatario
				</td>
				<td>
					<input type="text" name="docDestinatario" value ="${not empty pacote? pacote.docDestinatario : ''}">
				</td>
			</tr>
			<tr>
				<td>
					Doc. Remetente
				</td>
				<td>
					<input type="text" name="docRemetente" value ="${not empty pacote? pacote.docRemetente : ''}">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="${empty pacote? 'Enviar' : 'Alterar'}">
				</td>
				<td>
					<input type="reset" value="limpar">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>