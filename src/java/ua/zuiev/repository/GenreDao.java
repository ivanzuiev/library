/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.util.List;
import ua.zuiev.domain.Genre;

/**
 *
 * @author Vanes
 */
public interface GenreDao {
    
    List<Genre> selectAllGenres();
    
}
