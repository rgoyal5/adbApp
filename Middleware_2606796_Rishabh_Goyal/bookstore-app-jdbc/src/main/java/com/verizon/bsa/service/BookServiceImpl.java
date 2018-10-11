package com.verizon.bsa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.BookDao;
import com.verizon.bsa.model.Book;
@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDao bookDao;
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public Book getBookById(int bcode) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(bcode);
	}

	@Override
	public boolean deleteBookById(int bcode) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookById(bcode);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

}
