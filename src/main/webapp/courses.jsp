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
<link rel="stylesheet" href="assets/css/courses.css">
<link rel="icon" href="assets/images/pawprint.png">
<link rel="stylesheet" 
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<title>All courses - Tran Hoang Tin</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="content-container">

		<div class="tool-section">

			<form action="courses" method="post">
				<p>Find by name:</p>
				<input type="text" class="input-search" name="name"
					placeholder="Course's name" />
				<button type="submit" class="button-search">Search</button>
			</form>

			<hr>

			<form action="add_course" method="post" class="add-course">
				<p>Add new course:</p>
				<span>Name</span> 
				<input type="text" class="input-search" name="name" placeholder="Input course's name" required/> 
				<span>Lecturer</span> 
				<input type="text" class="input-search" name="lecturer" placeholder="Input lecturer's name" required/> 
				<span>Year</span> 
				<input type="number" step="1" class="input-search" min="1800" max="${thisYear}" name="year" placeholder="Ex: 2023" required/> 
				<span>Note</span> 
				<input type="text" class="input-search" name="note" placeholder="(optional)" />
				<button type="submit" class="button-search">Submit</button>
			</form>

		</div>

		<table class="table-course">
			<tr>
				<th>ID &nbsp; <a
					href="<%=request.getContextPath()%>/courses?sortby=class_id">
						<i class="fa-solid fa-sort"></i>
				</a>
				</th>
				<th>Name &nbsp; <a
					href="<%=request.getContextPath()%>/courses?sortby=name"> <i
						class="fa-solid fa-sort"></i>
				</a>
				</th>
				<th>Lecturer</th>
				<th>Year</th>
				<th>Note</th>
				<th>Detail</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="cou" items="${courseList}">

				<tr class="add-space">
					<td>${cou.id}</td>
					<td>${cou.name}</td>
					<td>${cou.lecturer}</td>
					<td>${cou.year}</td>
					<td>${cou.note}</td>
					<td><a
						href="<%=request.getContextPath()%>/course_detail?id=${cou.id}">
							<i class="fa-solid fa-circle-info"></i>
					</a></td>
					<td><a id ="delete-btn"
						href="<%=request.getContextPath()%>/delete_course?id=${cou.id}"
						onclick="return confirm('Are you sure you want to delete this course?');">
							<i class="fa-sharp fa-solid fa-trash"></i>
					</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>



</body>
</html>