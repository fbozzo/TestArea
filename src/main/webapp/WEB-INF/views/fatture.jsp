<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Utenti</title>
	</head>
	<body>
		
		<a href="/">&laquo; back</a>
		<br />
		
		<h1>Fatture</h1>
		
		<form:form action="/fatture" method="post" commandName="laFattura">
			<table>
				<tr>
					<td colspan="2">	
						<strong>Nuova Fattura</strong>
					</td>
				</tr>
				<tr>
					<td>
						Numero:
					</td>
					<td>
						<form:input path="numero"/>
					</td>
				</tr>
				<tr>
					<td>
						Importo €:
					</td>
					<td>
						<form:input path="importo"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="saveNewFattura" value="Conferma" />
					</td>
				</tr>
			</table>
		</form:form>
		
		<hr />
		
		<ul>
			<c:forEach items="${listaFatture}" var="item">
				<li><b>${item.numero}</b>: ${item.importo} (${item.utente.username})</li>
			</c:forEach>
		</ul>
		
	</body>
</html>