<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listagem Tarefas</title>
	</head>
	<body>
		<h2>-- Listagem de Tarefas --</h2> <br/><br/>
		<a href="novaTarefa">Cadastrar nova Tarefa</a> <br/><br/>
		
		<table>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalização?</th>
				<th>Data Finalização</th>
				<th></th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					
					<c:if test="${tarefa.finalizado eq false }">
						<td id="tarefa_${tarefa.id}">
							<a href="#" onclick="finalizaAgora(${tarefa.id})">Finalizar agora!</a>
						</td>
					</c:if>
					
					<c:if test="${tarefa.finalizado eq true }">
						<td>Finalizado</td>
					</c:if>
					
					<td id="tarefa_data_${tarefa.id}">
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td><a href="removeTarefa?id=${tarefa.id}">Deletar</a></td>
					<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				</tr>
			</c:forEach>
		</table>
		<script>
			function finalizaAgora(id) {
				$.post("finalizaTarefa", {'id' : id}, function(resposta){
					$("#tarefa_"+id).html("Finalizado");
					$("#tarefa_data_"+id).html(resposta);
				})
			}
		</script>
	</body>
</html>