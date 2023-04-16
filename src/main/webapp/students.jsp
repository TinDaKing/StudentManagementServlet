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
	<link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	<title>Student management by Tran Hoang Tin</title>
</head>
<body>
	<div class="nav-bar">
		<a href="<%=request.getContextPath()%>/students">
	    	<button class="button-nav-bar">Students</button></a>
	    <a href="<%=request.getContextPath()%>/courses">
	    	<button class="button-nav-bar">Courses</button>
	    </a>    
	    <a href="<%=request.getContextPath()%>/register">
	    	<button class="button-nav-bar">Register for course</button>
	    </a>  
    </div>
    <div class="content-container">
    
    	<div class="tool-section">
	    	
	    	<form action="students" method="post" >
	    		<p>Find by name:</p>
	            <input type="text" class="input-search" name="studentName" placeholder="student name"/>
				<button type="submit" class="button-search">Search</button>
	        </form>
	        
	        <form action="add_student" method="post" class="add-student">
	    		<p>Add new student:</p>
	    		<span>Name</span>
	            <input type="text" class="input-search" name="name" placeholder="Input name"/>
	            <span>Grade</span>
	            <input type="number" step="0.01" class="input-search" name="grade" placeholder="Ex: 8.25"/>
	            <span>Birthday</span>
	            <input type="date" class="input-search" name="birthday" placeholder="mm-dd-yyyy"/>
	            <span>Address</span>
	            <input type="text" class="input-search" name="address" placeholder="Input address"/>
	            <span>Note</span>
	            <input type="text" class="input-search" name="note" placeholder="(optional)"/>
				<button type="submit" class="button-search">Submit</button>
	        </form>

	    </div>
	    
	    <table class="table-student">
    	<tr>
    		<th>ID &nbsp; 
    			<a href="<%=request.getContextPath()%>/students?sortby=student_id">
    				<i class="fa-solid fa-sort"></i>
    			</a>
    		</th>
    		<th>Name &nbsp; 
    			<a href="<%=request.getContextPath()%>/students?sortby=name">
    				<i class="fa-solid fa-sort"></i>
    			</a>
    		</th>
    		<th>Grade &nbsp; 
    			<a href="<%=request.getContextPath()%>/students?sortby=grade">
    				<i class="fa-solid fa-sort"></i>
    			</a>
    		</th>
    		<th>Birthday</th>
    		<th>Address</th>
    		<th>Note</th>
    		<th>Detail</th>
    		<th>Delete</th>
    		
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
    				<a href="<%=request.getContextPath()%>/student-detail?id=${stu.id}">
    					<i class="fa-solid fa-circle-info"></i>
    				</a>
    			</td>
    			<td>
    				<a href="<%=request.getContextPath()%>/delete_student?id=${stu.id}" onclick="return confirm('Are you sure you want to delete this item?');">
    					<i class="fa-sharp fa-solid fa-trash"></i>
    				</a>
    			</td>
    		</tr>
	    </c:forEach>
    </table>
    
    </div>
    
    
   
</body>
</html>