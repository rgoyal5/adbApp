<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Employees List</title>
<link href="styles/site.css" rel="stylesheet" />
</head>
<body>
	<h3>Employee List</h3>
	<c:choose>
		<c:when test="${employees eq null or employees.size() eq 0 }">
			<h3>No Records Found</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Employee#</th>
					<th>Name</th>
					<th>Mobile Number</th>
					<th>Email</th>
					<th>DOB</th>
					<th>HRA</th>
					<th>Department</th>
					<th>BASIC</th>
				</tr>
				<tr>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.empId}</td>
							<td>${employee.firstName}  ${employee.lastName}</td>
							<td>${employee.mobileNumber}</td>
							<td>${employee.emailId}</td>
							<td>${employee.dateOfBirth}</td>
							<td>${employee.hra}</td>
							<td>${employee.dept}</td>
							<td>${employee.basic}</td>
							<c:if test="${currentUserName eq 'admin'}">
								<td><a href="editEmp?empId=${employee.empId}">Edit</a></td><span>|</span>
								<td><a href="deleteEmp?empId=${employee.empId}">Delete</a></td>
							</c:if>

						</tr>
					</c:forEach>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="home">Go To Home</a>
</body>
</html>