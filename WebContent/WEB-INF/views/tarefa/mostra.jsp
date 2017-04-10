<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="resources/js/jquery.js" ></script>
		<script src="resources/js/jquery-ui.js" ></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update Tarefa</title>
	</head>
	<body>
		<h2>-- Alterando Tarefa ${tarefa.id} --</h2>
		<form action="alteraTarefa" method="post">
			<input type="hidden" name="id" value="${tarefa.id }" />
			
			<label>Descrição:</label><br/>
			<textarea rows="5" cols="100" name="descricao">${tarefa.descricao}</textarea><br/><br/>
			
			<label>Finalizado?</label>
			<input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' } /> <br/><br/>
			
			<label>Data de finalização</label><br/>
			<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" /> <br/><br/>
			
			<input type="submit" value="Alterar" />
		</form>
	</body>
</html>