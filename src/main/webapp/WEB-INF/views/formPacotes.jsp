<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Pacote</title>
</head>
<body>
	<h3>${sucesso}</h3>
	<form action="" method="POST" >
		<table>
			<tr>
				<td>
					Código
				</td>
				<td>
					<input type="text" name="codigo">
				</td>
			</tr>
			<tr>
				<td>
					Destino
				</td>
				<td>
					<input type="text" name="destino">
				</td>
			</tr>
			<tr>
				<td>
					Origem
				</td>
				<td>
					<input type="text" name="origem">
				</td>
			</tr>
			<tr>
				<td>
					Destinatario
				</td>
				<td>
					<input type="text" name="destinatario">
				</td>
			</tr>
			<tr>
				<td>
					Remetente
				</td>
				<td>
					<input type="text" name="remetente">
				</td>
			</tr>
			<tr>
				<td>
					Doc. Destinatario
				</td>
				<td>
					<input type="text" name="docDestinatario">
				</td>
			</tr>
			<tr>
				<td>
					Doc. Remetente
				</td>
				<td>
					<input type="text" name="docRemetente">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Enviar">
				</td>
				<td>
					<input type="reset" value="limpar">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>