/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.domain;

import java.util.Collections;
import java.util.List;
import ua.zuiev.repository.GenreDaoImpl;

/**
 *
 * @author Vanes
 */
public class GenreList {
    
    private final List<Genre> genreList;

    public GenreList() {
        genreList=(new GenreDaoImpl()).selectAllGenres();
        Collections.sort(genreList);
    }
    
    public List<Genre> getGenreList(){
        return genreList;
    }
    
    
    
}
