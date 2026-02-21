package com.lms.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.lms.entity.Book;

public interface BookRepository extends JpaRepository <Book, Long>{

	List <Book> findByGenre(String gener);
	
	@Query("SELECT DISTINCT b.genre FROM Book b")
	List<String> findUniqueGenres();
}
