<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description"
	content="This is an asignment in Java course at HCMUS by Tran Hoang Tin">
<meta name="author" content="TinDaKing">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="assets/css/student-detail.css">
<link rel="icon" href="assets/images/pawprint.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<title>Student detail - Tran Hoang Tin</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class ="content-section">
		<div class="student-profile">
			<div class="student-info">
				<h2>ID: ${student.id}</h2>
				<h2>Name: ${student.name}</h2>
				<br>
				<p><b>Grade:</b> ${student.grade}</p>
				<p><b>Birthday:</b> ${student.birthday }</p>
				<p><b>Address:</b> ${student.address}</p>
				<p><b>Note:</b> ${student.note}</p>
				<button class="button-search" id="button-edit">Change data</button>
			</div>
			
			<form action="student_detail" method="post" class="edit-student hidden" id="form-edit">
				<p>Edit student:</p>
				<span>ID</span>
				<input type="text" class="input-search just-read" name="id" value="${student.id}" readonly/> 
				<span>Name</span> 
				<input type="text" class="input-search" name="name" value="${student.name}" /> 
				<span>Grade</span> 
				<input type="number" step="0.01" class="input-search" name="grade" value="${student.grade}" />
				<span>Birthday</span> 
				<input type="date" class="input-search" name="birthday" value="${student.birthday}" /> 
				<span>Address</span> 
				<input type="text" class="input-search" name="address" value="${student.address}" /> 
				<span>Note</span> 
				<input type="text" class="input-search" name="note" value="${student.note}" />
				<button type="submit" class="button-search">Submit</button>
			</form>
		</div>
		
		<h2>Courses this student joined</h2>
		<table class="table-course">
			<tr>
				<th>ID </th>
				<th>Name</th>
				<th>Lecturer</th>
				<th>Year</th>
				<th>Note</th>
				<th>Drop-out</th>
			</tr>
	
			<c:forEach var="cou" items="${courseList}">
				<tr class="add-space">
					<td>${cou.id}</td>
					<td>${cou.name}</td>
					<td>${cou.lecturer}</td>
					<td>${cou.year}</td>
					<td>${stu.note}</td>
					<td>
					 <a id ="delete-btn"
						href="<%=request.getContextPath()%>/cancel_register?student_id=${student.id}&course_id=${cou.id}"
						onclick="return confirm('Are you sure you want to cancel this register?');">
							<i class="fa-sharp fa-solid fa-trash"></i>
					</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script src="assets/js/student-detail.js"></script>
</body>
</html>