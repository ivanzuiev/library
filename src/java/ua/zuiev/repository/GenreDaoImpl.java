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
import ua.zuiev.domain.Genre;

/**
 *
 * @author Vanes
 */
public class GenreDaoImpl implements GenreDao{

    @Override
    public List<Genre> selectAllGenres() {
        
        List<Genre> genres = new ArrayList<>();

		try (Connection conn = (new LibraryConnectionFactory()).getConnection();

			PreparedStatement prepSt = conn
					.prepareStatement("SELECT * FROM genre");
			ResultSet rs = prepSt.executeQuery();) {

			while (rs.next()) {
				Genre genre = new Genre();
				genre.setId(rs.getInt(1));
				genre.setGenreName(rs.getString(2));
				
				genres.add(genre);
			}

		} catch (SQLException ex) { 
                Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
		return genres;
	}
    }
    

