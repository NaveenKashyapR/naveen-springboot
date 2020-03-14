package com.naveen.bootExceptionHandling.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class BookDTO implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BookDTO.class);

	public BookDTO() {
		LOGGER.debug("Object successfully created for " + this.getClass().getSimpleName());
	}

	@Id
	@GenericGenerator(name = "idGenerator",strategy = "increment")
	@GeneratedValue(generator = "idGenerator")
	private Integer bookId;
	@NotNull(message = "Please do enter a valid name")
	@Size(min = 2, max =20, message ="Name of the book has to be within the prescribed limit")
	private String bookName;
	@NotNull(message = "Please do enter the number of books")
    @Min(value=1,message="Please enter minimum one book")	
	private Integer noOfBooks;
	private Double bookPrice;
	@NotNull(message = "Please enter author name")
	private String bookAuthor;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate yearOfPublish;

	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", bookName=" + bookName + ", noOfBooks=" + noOfBooks + ", bookPrice="
				+ bookPrice + ", bookAuthor=" + bookAuthor + ", yearOfPublish=" + yearOfPublish + "]";
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public LocalDate getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(LocalDate yearOfPublish) {
		this.yearOfPublish = yearOfPublish;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
}
