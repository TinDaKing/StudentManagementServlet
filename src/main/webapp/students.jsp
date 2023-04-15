<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="This is an asignment in Java course at HCMUS by Tran Hoang Tin">
	<meta name="author" content="TinDaKing">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="icon" href="assets/images/pawprint.png">
	<title>Student managemnet by Tran Hoang Tin</title>
</head>
<body>
	<div class="nav-bar">
		<a href="<%=request.getContextPath()%>/students">
	    	<button class="button-nav-bar">Students</button></a>
	    <a href="<%=request.getContextPath()%>/courses">
	    	<button class="button-nav-bar">Courses</button>
	    </a>    
    </div>
    <table class="table-student">
    	<tr>
    		<th>ID</th>
    		<th>Name</th>
    		<th>Grade</th>
    		<th>Birthday</th>
    		<th>Address</th>
    		<th>Note</th>
    		<th>Detail</th>
    	</tr>
    	<c:forEach var="stu" items="${studentList}">
    		<hr>
    		<tr>
    			<td>${stu.id}</td>
    			<td>${stu.name}</td>
    			<td>${stu.grade}</td>
    			<td>${stu.birthday}</td>
    			<td>${stu.address}</td>
    			<td>${stu.note}</td>
    			
    			<td><a href="<%=request.getContextPath()%>/student-detail?id=${stu.id}" class="close">Detail here</a></td>
    		</tr>
	    </c:forEach>
    </table>
    
</body>
</html>