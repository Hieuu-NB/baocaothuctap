package com.example.tt1012022.controller;

import com.example.tt1012022.entity.Book;
import com.example.tt1012022.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    @Autowired
//    private BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<Book>> showAllBook(){
        List<Book> x = bookService.getAllBook();
        return ResponseEntity.ok(x);
    }
//    @GetMapping("/sortBookById")
//    public void sortListBookById(){
////        List<Book> x = bookService.getAllBookSortId();
//        bookService.getAllBookSortId();
//    }

    @GetMapping("/abc/{id}")
    public ResponseEntity<Book> showBookById(@PathVariable Long id){
        Book x = bookService.getBookById(id);
        return ResponseEntity.ok(x);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Book> showBook(@PathVariable String name){
        Book x = bookService.getBookInLibrary(name);
        return ResponseEntity.ok(x);
    }
    @GetMapping("/searchId/{author}") // search id with pathVariable
    public ResponseEntity<Book> showID(@PathVariable String author){
        Book x = bookService.getBookByAuthor(author);
        return ResponseEntity.ok(x);
    }

    @GetMapping("/searchID") // search id with requestParam
    public ResponseEntity<Book> showid(@RequestParam String author){
        Book x = bookService.getBookByAuthor(author);
        return ResponseEntity.ok(x);
    }

    @GetMapping("/search-book-by-cost") // tìm book có cost qua requestParam
    public ResponseEntity<Book> showBookByCost(@RequestParam Long cost){
        Book x = bookService.getBookByCost(cost);
        return ResponseEntity.ok(x);
    }
//    @GetMapping("/get-all-book")
//    public ResponseEntity<List<Book>> getAllBook(){
//        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
//    }
//
//
//    @GetMapping("/get-book-by-name/{name}")
//    public ResponseEntity<Book> showBook(@PathVariable String name){
//        Book x = bookService.getBookByName(name);
//        return ResponseEntity.ok(x);
//    }
//
//    @PostMapping("/post-book-by-name")
//    public ResponseEntity<Book> postBookByName(@RequestBody BookRequest bookRequest){
//        return new ResponseEntity<>(bookService.getBookByName(bookRequest.getNameBook()), HttpStatus.OK);
//    }

    @GetMapping("/search-contain-name-book")
    public ResponseEntity<List<Book>> showListBook(@RequestParam String str){
        List<Book> x = bookService.getListBookByStr(str);
        return ResponseEntity.ok(x);
    }

    @PostMapping("/abc")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book x = bookService.addNewBook(book);
        return ResponseEntity.ok(x);
    }

    @PutMapping("/update-book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@RequestParam Long id) throws Exception{
        try {
            Book book1 = bookService.updateBook(book,id);
            return ResponseEntity.ok(book1);
        }catch (Exception e){
            System.out.println("khong co id nay !!!");
        }
        return null;
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookByid(@PathVariable Long id){
        bookService.deleteBookById(id);
    }

    @DeleteMapping("/delete-book-by-cost")
    public void deleteBookByCost(@RequestParam Long cost){
        bookService.deleteBookByCost(cost);
        System.out.println(123);
    }
}
