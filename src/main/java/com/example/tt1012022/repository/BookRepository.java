package com.example.tt1012022.repository;

import com.example.tt1012022.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByNameBookLikeIgnoreCase(String name);
//    Book findByAuthorIsNotContainingIgnoreCase(String author);
    Book findBookByCost(Long cost); //

//    List<Book> findAllByOrOrderById();

//    void findAllByOrOrderById();

    Book findBookById(Long id);

    Book findByAuthorIs(String author);  // Lấy dữ liệu từ database lên


    void deleteById(Long id);

    void deleteBookByCost(Long cost);



//    List<Book> findAll();
// các hàm có sẵn trong jpa tương ứng với tên biến
}


























