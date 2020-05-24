<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Log</title>
</head>
<body>
 <h3>${sucesso}</h3>
<table>
		<thead>
			<tr>
				<th>
					Código Pacote
				</th>
				<th>
					Código
				</th>
				<th>
					Mensagem
				</th>
				<th>
					Data
				</th>
				<th>
				</th>
				<th>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty logs}">
					<c:forEach items="${logs}" var="log">
						<tr>
							<td>
								${log.pacote.codigo}
							</td>
							<td>
								${log.id}
							</td>
							<td>
								${log.mensagem}
							</td>
							<td>
								${log.data}
							</td>
							<td>
								<form action="${log.id}" method="GET">
									<input type="submit" value ="Editar">
								</form>
							</td>
							<td>
								<form action="remover/${log.id}" method="POST">
									<input type="submit" value ="Excluir">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td col="6"> Nenhum Log cadastrado</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>