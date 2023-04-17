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
<link rel="stylesheet" href="assets/css/register.css">
<link rel="icon" href="assets/images/pawprint.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<title>Register course - Tran Hoang Tin</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="content-section">
		<h2>Register student to a course</h2>
		<form action="register" method="post" class="form-register">
			<span>Student ID</span> 
			<input type="number" step="1" class="input-search" min="1" max="99999999" name="studentId" placeholder="Ex: 9" /> 
			<i class="fa-solid fa-right-to-bracket"></i>
			<span>Course ID</span> 
			<input type="number" step="1" class="input-search" min="1" max="99999999" name="courseId" placeholder="Ex: 10" /> 
			<button type="submit" class="button-search">Submit</button>
		</form>
	</div>

</body>
</html>