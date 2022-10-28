<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
    <style type="text/css">
    	body {background-color: silver;}
    </style>
</head>
<body>
	<div align="center">
		<p> <b> BOOKS LIST.. </b> </p>
	</div>
    <div align="center">
		<table border="2px">
		<tr>
		<td> <b> ID </b> </td>
		<td> <b> NAME </b> </td>
		<td> <b> AUTHOR </b> </td>
		</tr>
        <c:forEach items="${books}" var="book">
            <tr>
            	<td> <div>${book.id}</div> </td>
            	<td> <a href="/books/${book.id}">${book.name}</a> </td>
            	<td> <div>${book.author}</div> </td>
            </tr>
        </c:forEach>
    	</table>
    </div>
    
    <div align="left">
    	<form action="/addBook" method="post">
    		<label>Book Id :</label> <input type="number" name="id"/> </br>
    		<label>Book Name :</label> <input type="text" name="name"/> </br>
    		<label>Book Author :</label> <input type="text" name="author"/> </br>
    		<input type="submit" value="Add Record">
    	</form>
    </div>
</body>
</html>