/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.domain;

import java.util.Collections;
import java.util.List;
import ua.zuiev.repository.AuthorDaoImpl;

/**
 *
 * @author Vanes
 */
public class AuthorList {
    
        private final List<Author> listAuthor;

    public AuthorList() {
        listAuthor=(new AuthorDaoImpl()).getAllAuthors();
        Collections.sort(listAuthor);
    }
        
        

    /**
     * Get the value of listAuthor
     *
     * @return the value of listAuthor
     */
    public List<Author> getListAuthor() {
        return listAuthor;
    }

    

    
}
