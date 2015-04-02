<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link href="css/index.css" type="text/css" rel="stylesheet">
</head>
<body>

<div id="wrapper">

	<div id="right">
	<h1><em>Добро пожаловать в онлайн бибилотеку!</em></h1>	
	</div>
	
	<div id="form">
		<form action="MainServlet">
		<p align="center"><em>Введите Ваше имя</em></p>
		<p align="center">
		<input class="input1" type="text" name="userName" size="15">
		<input class="input2" type="submit" value="Ввод">
		</p>
		</form>
	</div>
	

</div>

</body>
</html>