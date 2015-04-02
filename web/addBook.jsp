<%-- 
    Document   : addBook
    Created on : 31.03.2015, 16:40:59
    Author     : Vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add book</title>
    </head>
    <body>
        <h1>Страница для добавления книги</h1>
        
        <h3>${addbook}</h3>
        <a href="MainServlet">на главную</a>

        <form action="RecieverServlet" enctype="multipart/form-data" method="post">
            <p>Название книги: <br><input  type="text" name="titleBook"  size="30"></p>

            <p>Автор книги: <br>
                <select name="authorId">
                    <c:forEach items="${authors}" var="author">                                
                        <option value="${author.id}">${author.name}</option>                                
                    </c:forEach>
                </select>
            </p>

            <p>Год издания: <br><input  type="text" name="publishYear"  size="30"></p>
            <p>Количество страниц: <br><input  type="text" name="pageCount"  size="30"></p>
            
           <p>Издательство: <br>
                <select name="publisherId">
                    <c:forEach items="${publishers}" var="publisher">                                
                        <option value="${publisher.id}">${publisher.name}</option>                                
                    </c:forEach>
                </select>
            </p> 
            
            <p>Жанр: <br>                
                <select name="genreId">                    
                    <c:forEach items="${genres}" var="genre">                                
                        <option value="${genre.id}">${genre.genreName}</option>                                
                    </c:forEach>
                </select>
            </p>

            <p>Добавить обложку<br><input type="file" name="imageFile" accept="image/jpeg"></p>
            <p>Добавить файл книги<br><input type="file" name="bookFile" accept="application/pdf"></p>
            <br>
            <input type="submit" value="Добавить">
        </form>

    </body>
</html>
