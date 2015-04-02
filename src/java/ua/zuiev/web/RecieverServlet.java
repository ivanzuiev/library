/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.web;

import com.ibm.useful.http.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.zuiev.repository.BookDaoImpl;

/**
 *
 * @author Vanes
 */
public class RecieverServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean res=false;
        

        try {

            //разбор формата multipart и помещение информации из запроса в поля объекта
            //класса PostData
            PostData multidata = new PostData(request);

            //извлечение посланной информации
            String titleBook = multidata.getParameter("titleBook");            
            //String decodedTitleBook = new String(titleBook.getBytes("ISO-8859-1"), "UTF-8");
             
            int authorId = Integer.parseInt(multidata.getParameter("authorId"));
            String publishYear = multidata.getParameter("publishYear");
            int pageCount = Integer.parseInt(multidata.getParameter("pageCount"));
            int publisherId = Integer.parseInt(multidata.getParameter("publisherId"));
            int genreId = Integer.parseInt(multidata.getParameter("genreId"));
            byte[] imageFile = multidata.getFileData("imageFile").getByteData();
            byte[] bookFile = multidata.getFileData("bookFile").getByteData();
            
            res=(new BookDaoImpl()).addNewBook(titleBook, bookFile, pageCount, genreId, authorId, publishYear, publisherId, imageFile);

            

            //ну и дальше какая-то генерация ответа кленту...
        } catch (Exception e) {
        }
        
        if(res==true){
            request.setAttribute("addbook", "Книга успешно добавлена");
        }else{
            request.setAttribute("addbook", "Не удалось добавить книгу");
        }
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addBook.jsp");
        dispatcher.forward(request, response);
    }

   
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
