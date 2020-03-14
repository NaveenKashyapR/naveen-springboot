package com.naveen.bootExceptionHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.bootExceptionHandling.dto.BookDTO;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Integer>{

	
}
