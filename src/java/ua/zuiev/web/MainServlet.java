/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.zuiev.domain.Author;
import ua.zuiev.domain.AuthorList;
import ua.zuiev.domain.Genre;
import ua.zuiev.domain.GenreList;
import ua.zuiev.domain.Publisher;
import ua.zuiev.repository.PublisherDaoImpl;

/**
 *
 * @author Vanes
 */
public class MainServlet extends HttpServlet {

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

        List<Author> authors = new AuthorList().getListAuthor();
        List<Genre> genres = new GenreList().getGenreList();
        List<Publisher> publishers = new PublisherDaoImpl().getAllPublishers();
        HttpSession session = request.getSession();

        String userName = request.getParameter("userName");
        if (userName != null) {
            String decoded = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
            session.setAttribute("userName", decoded);
        }

        session.setAttribute("publishers", publishers);

        session.setAttribute("authors", authors);
        session.setAttribute("genres", genres);
        session.setAttribute("context_path", request.getContextPath());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/main.jsp");
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
