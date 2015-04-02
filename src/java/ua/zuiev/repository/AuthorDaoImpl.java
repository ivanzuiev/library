package ua.zuiev.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.zuiev.domain.Author;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public List<Author> getAllAuthors() {

		List<Author> authors = new ArrayList<>();

		try (Connection conn = (new LibraryConnectionFactory()).getConnection();

			PreparedStatement prepSt = conn
					.prepareStatement("SELECT * FROM author");
			ResultSet rs = prepSt.executeQuery();) {

			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt(1));
				author.setName(rs.getString(2));
				author.setDateBirth(rs.getString(3));
				authors.add(author);
			}

		} catch (SQLException ex) { 
                Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
		return authors;
	}

}
