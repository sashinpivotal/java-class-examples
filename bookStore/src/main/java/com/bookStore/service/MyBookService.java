package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBook;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBook book) {
		mybook.save(book);
	}
	
	public List<MyBook> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
