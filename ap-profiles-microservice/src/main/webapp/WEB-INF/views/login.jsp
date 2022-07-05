<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Article Point</title>

</head>
<body>
		

			<div>
				<h1>Login here</h1>
				<form:form action="/portal/login" method="post" modelAttribute="user">
						<form:input type="text" path="userName" id="username" name="name" placeholder="Enter Username" />
					
						<form:input type="password" path="password" 
							id="password" name="password" placeholder="Enter Password"/>
					
					<form:button type="submit" class="btn btn-login">Login</form:button>
				</form:form>
			</div>

</body>

</html>