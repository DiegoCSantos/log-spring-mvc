<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Pacotes</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>
					Código
				</th>
				<th>
					Destino
				</th>
				<th>
					Origem
				</th>
				<th>
					Destinatario
				</th>
				<th>
					Remetente
				</th>
				<th>
					Doc. Destinatario
				</th>
				<th>
					Doc. Remetente
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty pacotes}">
					<c:forEach items="${pacotes}" var="pacote">
						<tr>
							<td>
								${pacote.codigo}
							</td>
							<td>
								${pacote.destino}
							</td>
							<td>
								${pacote.origem}
							</td>
							<td>
								${pacote.destinatario}
							</td>
							<td>
								${pacote.remetente}
							</td>
							<td>
								${pacote.docDestinatario}
							</td>
							<td>
								${pacote.docRemetente}
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td col="7"> Nenhum pacote cadastrado</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>