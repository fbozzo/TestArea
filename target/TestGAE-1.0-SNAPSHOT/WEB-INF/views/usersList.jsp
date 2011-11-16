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
		
		<h1>Utenti</h1>
		
		<form:form action="/users" method="post" commandName="theUser">
			<table>
				<tr>
					<td colspan="2">	
						<strong>Nuovo Utente</strong>
					</td>
				</tr>
				<tr>
					<td>
						Username:
					</td>
					<td>
						<form:input path="username"/>
					</td>
				</tr>
				<tr>
					<td>
						Nome:
					</td>
					<td>
						<form:input path="firstName"/>
					</td>
				</tr>
				<tr>
					<td>
						Cognome:
					</td>
					<td>
						<form:input path="lastName"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="saveNewUser" value="Conferma" />
					</td>
				</tr>
			</table>
		</form:form>
		
		<hr />
		
		<ul>
			<c:forEach items="${utenti}" var="item">
				<li><b>${item.username}</b>: ${item.firstName} ${item.lastName}</li>
			</c:forEach>
		</ul>
		
	</body>
</html>