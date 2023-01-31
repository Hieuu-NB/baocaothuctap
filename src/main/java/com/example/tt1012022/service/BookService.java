package com.example.tt1012022.service;

import com.example.tt1012022.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();                    //get

//    void getAllBookSortId();                //get

    Book getBookInLibrary(String name);         //get

    Book getBookById(Long id);

    List<Book> getListBookByStr(String str); //hàm tìm sách chứa kí tự giống //get



    Book getBookByAuthor(String author);  // tên hàm để gọi trong controller //get

    Book getBookByCost(Long cost);              //get

    Book addNewBook(Book book);      // post

//    Book fixBook(Book book);            // put

    Book updateBook(Book book,Long id) throws Exception;  // put

    void deleteBookById(Long id);

    void deleteBookByCost(Long cost);

}
