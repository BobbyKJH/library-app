package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMemoryRepository implements BookRepository {
//    private final List<Book> book = new ArrayList<Book>();

    @Override
    public void saveBook() {
        System.out.println("Memory");

    }
}
