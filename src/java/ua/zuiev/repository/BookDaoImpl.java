/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.zuiev.domain.Book;

/**
 *
 * @author Vanes
 */
public class BookDaoImpl implements BookDao {

    private static final String SELECT_ALL = "select book.id, book.name,"
            + " book.page_count pageCount, genre.name as genre,\n"
            + "author.fio as author, book.publisher_year as publishDate,"
            + " publisher.name as publisher,\n"
            + "book.image\n"
            + " from book\n"
            + "inner join genre\n"
            + "ON 	book.genre_id=genre.id\n"
            + "inner join author\n"
            + "on book.author_id=author.id\n"
            + "inner join publisher\n"
            + "on book.publisher_id=publisher.id";

    private static final String SELECT_ALL_BOOKS = (new StringBuilder(SELECT_ALL).append(";")).toString();

    private static final String ADD_BOOK = "insert into book (name, content, "
            + "page_count, genre_id, author_id, publisher_year, publisher_id, "
            + "image) values (?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<Book> selectAllBooks() {
        return getBookList(SELECT_ALL_BOOKS);
    }

    //method for pagination
    public List<Book> selectAllBooks(int offset, int noOfRecords) {
        String sql = (new StringBuilder(SELECT_ALL).append(" limit " + offset + ", " + noOfRecords + ";")).toString();
        setNoOfRecords("select count(*) from book;");
        return getBookList(sql);
    }

    //method for pagination
    private void setNoOfRecords(String sql) {

        try (Connection conn = (new LibraryConnectionFactory()).getConnection();
                PreparedStatement prepSt = conn
                .prepareStatement(sql);
                ResultSet rs = prepSt.executeQuery();) {

            rs.next();
            noOfRecords = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public List<Book> selectByGenreId(int genreId) {
        String sql = (new StringBuilder(SELECT_ALL).append(" where book.genre_id=" + genreId + ";")).toString();
        return getBookList(sql);
    }

    @Override
    public List<Book> selectByAuthorId(int authorId) {
        String sql = (new StringBuilder(SELECT_ALL).append(" where author.id=" + authorId + ";")).toString();
        return getBookList(sql);
    }

    @Override
    public List<Book> selectBySearch(String searchString, String searchType) {

        String sql;
        if (searchType.equals("author")) {
            sql = (new StringBuilder(SELECT_ALL).append(" where lower(author.fio) like '%" + searchString.toLowerCase() + "%' order by book.name;")).toString();
        } else {
            sql = (new StringBuilder(SELECT_ALL).append(" where lower(book.name) like '%" + searchString.toLowerCase() + "%' order by book.name;")).toString();
        }
        return getBookList(sql);
    }

    private List<Book> getBookList(String sql) {
        List<Book> books = null;

        try (Connection conn = (new LibraryConnectionFactory()).getConnection();
                PreparedStatement prepSt = conn
                .prepareStatement(sql);
                ResultSet rs = prepSt.executeQuery();) {

            books = extract(rs);

        } catch (SQLException e) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return books;
    }

    private List<Book> extract(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setPageCount(resultSet.getInt("pageCount"));
            book.setGenre(resultSet.getString("genre"));
            book.setAuthor(resultSet.getString("author"));
            book.setPublishDate(resultSet.getString("publishDate"));
            book.setPublisher(resultSet.getString("publisher"));
            book.setImage(resultSet.getBytes("image"));
            books.add(book);
        }
        return books;
    }

    @Override
    public byte[] getContentBookById(int id) {
        byte[] content = null;
        try (Connection conn = (new LibraryConnectionFactory()).getConnection();
                PreparedStatement prepSt = conn
                .prepareStatement("select content from book where id=" + id + ";");
                ResultSet rs = prepSt.executeQuery();) {

            rs.next();
            content = rs.getBytes(1);

        } catch (SQLException e) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return content;
    }

    private int noOfRecords;

    public int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public boolean addNewBook(String title, byte[] content, int pageCount, int genreId, int authorId, String publishYear, int publisherId, byte[] image) {
            
        boolean result=false;
        
        try (Connection conn = (new LibraryConnectionFactory()).getConnection();
                PreparedStatement prepSt = conn
                .prepareStatement(ADD_BOOK);){
            
            prepSt.setString(1, title);
            prepSt.setBytes(2, content);
            prepSt.setInt(3, pageCount);
            prepSt.setInt(4, genreId);
            prepSt.setInt(5, authorId);
            prepSt.setString(6, publishYear);
            prepSt.setInt(7, publisherId);
            prepSt.setBytes(8, image);
            
            result= prepSt.executeUpdate()==1;
            

        } catch (SQLException e) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return result;

    }

}
