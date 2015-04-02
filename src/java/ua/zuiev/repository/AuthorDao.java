package ua.zuiev.repository;

import java.util.List;

import ua.zuiev.domain.Author;

public interface AuthorDao {
	
	List<Author> getAllAuthors();

}
