package com.example.tt1012022.service;

import com.example.tt1012022.entity.Book;
import com.example.tt1012022.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;  // repository lấy dữ liệu từ DB


    @Override // lấy ra tất cả danh sách trong DB
    public List<Book> getAllBook() {
        List<Book> x = bookRepository.findAll();
        return x;
    }

//    @Override
//    public void getAllBookSortId() {
//        bookRepository.findAllByOrOrderById();
//    }

    @Override
    public Book getBookInLibrary(String name) {
        var x = bookRepository.findByNameBookLikeIgnoreCase(name);
//        List<Book> all = bookRepository.findAll();
        return x;
    }

    @Override
    public Book getBookById(Long id) {
        var x = bookRepository.findBookById(id);
        return x; // trả về book có id như id truyền vào
    }

    @Override  // tìm danh sách sách có nameBook có kí tự giống str
    public List<Book> getListBookByStr(String str) {
        List<Book> bookList = new ArrayList<Book>();
        for (Book book : bookRepository.findAll()){
            if (book.getNameBook().contains(str)){
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public Book getBookByAuthor(String author) {  // override lại trong interface
        var book = bookRepository.findByAuthorIs(String.valueOf(author));
        return book;
    }

    @Override
    public Book getBookByCost(Long cost) {
        var book = bookRepository.findBookByCost(cost);
        return book;
    }

    @Override
    public Book addNewBook(Book book) {
        var bookNew = bookRepository.save(book);
        return bookNew;
    }


    @Override                           // put
    public Book updateBook(Book book, Long id) throws Exception {
        Optional<Book> bookOp = bookRepository.findById(id);
        if(bookOp.isEmpty()){
            throw  new Exception();
        }

        Book bookOld = bookOp.get();
        bookOld.setNameBook(book.getNameBook());
        bookOld.setCost(book.getCost());
        bookOld.setAuthor(book.getAuthor());
        bookOld.setCost(book.getCost());

        bookRepository.save(bookOld);
        return bookOld;
    }

    @Override
    public void deleteBookById(Long id) {
//        var book = bookRepository.deleteBookById(id);
//        return book;

        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBookByCost(Long cost) {
        bookRepository.deleteBookByCost(cost);
    }
}
