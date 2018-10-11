<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Home Page</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h1>Employees Application</h1>

	<a href="employeeList">Employee List</a>
	<c:choose>
		<c:when test="${currentUserName ne null}">
			<a href="searchEmployee">Search Employee List</a>
			<br />
			<br />
			<c:if test="${currentUserName eq 'admin'}">
				<a href="addEmployee">Add Employee</a>
				<br />
			</c:if>
			<strong>Welcome! ${currentUserName}</strong>,
				<a href="logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="login">SignIn</a>
		</c:otherwise>
	</c:choose>


</body>
</html>