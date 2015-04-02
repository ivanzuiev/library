
package ua.zuiev.domain;

import java.awt.Image;

/**
 *
 * @author Vanes
 */
public class Book {
    
    private int id;
    
    private String name;
    
    private int pageCount;
    
    private String genre;
    
    private String author;
    
    private String publishDate;
    
    private String publisher;
    
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    
    public String getPublisher() {
        return publisher;
    }

    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
