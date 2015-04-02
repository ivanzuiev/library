

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../jspf/sidebar.jspf" %>

<div class="content">


    <c:forEach items="${books}" var="book">


        <div class="book_info">        

            <div class="book_title"><h4 align="center" style="color: #4E0008; margin: auto">${book.name}</h4></div>
            <br>
            <div class="book_image">
                <img src="${context_path}/ImageServlet?bookId=${book.id}" height="250" width="190">
            </div>

            <div class="book_details">
                <br><strong>Издательство: </strong>${book.publisher}
                <br><strong>Страниц: </strong>${book.pageCount}
                <br><strong>Год издания: </strong>${book.publishDate}
                <br><strong>Автор: </strong>${book.author}
                <br><a href="DownloadServlet?bookId=${book.id}">Скачать</a>
            </div>

        </div>          

    </c:forEach>





    <br>
    <div>
        <table align="center" border="0" cellpadding="5" cellspacing="5">
            <tr>

                <%--For displaying Previous link except for the 1st page --%>

                <c:if test="${currentPage != 1}">
                    <td><a href="PaginationServlet?page=${currentPage - 1}">Previous</a></td>
                </c:if>

                <%--For displaying Page numbers. The when condition does not display a link for the current page--%>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td><strong>${i}</strong></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="PaginationServlet?page=${i}">${i}</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                <%--For displaying Next link --%>
                <c:if test="${currentPage lt noOfPages}">
                    <td><a href="PaginationServlet?page=${currentPage + 1}">Next</a></td>
                </c:if>      

            </tr>
        </table>
    </div>



</div>


