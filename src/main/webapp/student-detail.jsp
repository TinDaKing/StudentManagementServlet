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

	<div class="student-info">
		<h2>ID: 3</h2>
		<h2>Name: Tran Hoang Tin</h2>
		<br>
		<p>
			<b>Grade:</b> 8.25
		</p>
		<p>
			<b>Birthday:</b> 02/06/2015
		</p>
		<p>
			<b>Address:</b> 92 Nguyen Hue Quan 1 HCM
		</p>
		<p>
			<b>Note:</b> good
		</p>
		<button class="button-search" id="button-edit">Change data</button>

		<form action="student-detail" method="post" id="form-edit"
			class="add-student hidden">
			<p>Edit student:</p>
			<span>ID</span> 
			<input type="text" class="input-search" name="id" placeholder="Input new id" /> 
			<span>Name</span> 
			<input type="text" class="input-search" name="name" placeholder="Input new name" /> 
			<span>Grade</span> 
			<input type="number" step="0.01" class="input-search" name="grade" placeholder="Ex: 8.25" />
			<span>Birthday</span> 
			<input type="date" class="input-search" name="birthday" placeholder="mm-dd-yyyy" /> 
			<span>Address</span> 
			<input type="text" class="input-search" name="address" placeholder="Input new address" /> 
			<span>Note</span> 
			<input type="text" class="input-search" name="note" placeholder="(optional)" />
			<button type="submit" class="button-search">Submit</button>
		</form>
	</div>

	<script src="assets/js/student-detail.js"></script>
</body>
</html>