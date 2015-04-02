/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.util.List;
import ua.zuiev.domain.Book;

/**
 *
 * @author Vanes
 */
public interface BookDao {

    List<Book> selectAllBooks();

    List<Book> selectByGenreId(int genreId);

    List<Book> selectByAuthorId(int authorId);

    List<Book> selectBySearch(String searchString, String searchType);

    byte[] getContentBookById(int id);

    boolean addNewBook(String title, 
            byte[] content, int pageCount, 
            int genreId, int authorId, 
            String publishYear, 
            int publisherId, byte[] image);

}
