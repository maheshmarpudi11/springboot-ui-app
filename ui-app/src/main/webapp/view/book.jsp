<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
   	<style type="text/css">
    	body {background-color: silver;}
    </style>
   	
</head>
<body>
	
	<div align="left">
		<p align="left">	<a href="/books"> Books Page</a> </p>
	</div>

    <div align="center">
        <b>Book id:</b> ${book.id}<br>
        <b>Book name:</b> ${book.name}<br>
        <b>Book author:</b> ${book.author}<br>
    </div>
</body>
</html>