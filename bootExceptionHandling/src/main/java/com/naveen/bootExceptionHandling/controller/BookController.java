package com.naveen.bootExceptionHandling.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.bootExceptionHandling.dto.BookDTO;
import com.naveen.bootExceptionHandling.exception.BookNotFoundException;
import com.naveen.bootExceptionHandling.repository.BookRepository;

@RestController
public class BookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookRepository bookRepository;

	public BookController() {
		LOGGER.debug("Object successfully created for " + this.getClass().getSimpleName());
	}

	@PostMapping("/add")
	public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
		LOGGER.debug("Entering addBook method in Book Controller");
		bookDTO.setBookPrice((double) (bookDTO.getNoOfBooks() * 100));
		bookRepository.save(bookDTO);
		LOGGER.debug("Book object successfully saved " + bookDTO);
		return new ResponseEntity<BookDTO>(bookDTO,HttpStatus.CREATED);
	}

	@GetMapping("/{bookId}")
	public BookDTO getBookById(@PathVariable("bookId") Integer bookId) {
		LOGGER.debug("Entering getBookById method in Book Controller");
		return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
	}

	@GetMapping("/allBooks")
	public ResponseEntity<List<BookDTO>> getAll() {
		LOGGER.debug("Entering getAll method in Book Controller");
		return new ResponseEntity<List<BookDTO>>(bookRepository.findAll(), HttpStatus.OK);
	}
}
