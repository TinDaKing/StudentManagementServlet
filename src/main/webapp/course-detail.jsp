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
<link rel="stylesheet" href="assets/css/course-detail.css">
<link rel="icon" href="assets/images/pawprint.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<title>Course detail - Tran Hoang Tin</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class ="content-section">
		<div class="course-profile">
			<div class="course-info">
				<h2>ID: ${course.id}</h2>
				<h2>Name: ${course.name}</h2>
				<br>
				<p><b>Lecturer:</b> ${course.lecturer}</p>
				<p><b>Year:</b> ${course.year}</p>
				<p><b>Note:</b> ${course.note}</p>
				<button class="button-search" id="button-edit">Change data</button>
			</div>
			
			<form action="course_detail" method="post" class="edit-course hidden" id="form-edit">
				<p>Edit course:</p>
				<span>ID</span>
				<input type="text" class="input-search just-read" name="id" value="${course.id}" readonly/> 
				<span>Name</span> 
				<input type="text" class="input-search" name="name" value="${course.name}" /> 
				<span>Lecturer</span> 
				<input type="text"  class="input-search" name="lecturer" value="${course.lecturer}" />
				<span>Year</span> 
				<input type="number" step="1" class="input-search" min="1800" max="${thisYear}" name="year" value="${course.year}" /> 
				<span>Note</span> 
				<input type="text" class="input-search" name="note" value="${course.note}" />
				<button type="submit" class="button-search">Submit</button>
			</form>
		</div>
		
		<h2>Student list of this course</h2>
		<table class="table-course">
			<tr>
				<th>ID </th>
				<th>Name</th>
				<th>Grade</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Note</th>
				<th>Expel</th>
			</tr>
	
			<c:forEach var="stu" items="${studentList}">
				<tr class="add-space">
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.grade}</td>
					<td>${stu.birthday}</td>
					<td>${stu.address}</td>
					<td>${stu.note}</td>
					<td>
					 <a id ="delete-btn"
						href="<%=request.getContextPath()%>/cancel_register?student_id=${stu.id}&course_id=${course.id}&path=course_detail?id=${course.id}"
						onclick="return confirm('Are you sure you want to cancel this register?');">
							<i class="fa-sharp fa-solid fa-trash"></i>
					</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script src="assets/js/pop-up-form.js"></script>
</body>
</html>