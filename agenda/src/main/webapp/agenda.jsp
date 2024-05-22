<%@ 
page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>AGENDA DE CONTATOS</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>AGENDA DE CONTATOS</h1>
	<a href="novo.html" class="botao_novocontato">NOVO CONTATO</a>

	<table id="tabela"> 
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i <lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
				</tr>
			<%} %>
		</tbody>
		
	
	</table>

</body>
</html>