package com.tananushka.javaadvance.module01.repository;

import com.tananushka.javaadvance.module01.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
