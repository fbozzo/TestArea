<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
		
		<form action="/users" method="post">
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
						<input type="text" name="username" />
					</td>
				</tr>
				<tr>
					<td>
						Nome:
					</td>
					<td>
						<input type="text" name="firstName" />
					</td>
				</tr>
				<tr>
					<td>
						Cognome:
					</td>
					<td>
						<input type="text" name="lastName" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="saveNewUser" value="Conferma" />
					</td>
				</tr>
			</table>
		</form>
		
		<hr />
		
		<ul>
			<c:forEach items="${utenti}" var="item">
				<li><b>${item.username}</b>: ${item.firstName} ${item.lastName}</li>
			</c:forEach>
		</ul>
		
	</body>
</html>