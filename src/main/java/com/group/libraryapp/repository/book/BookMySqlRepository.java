package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/** Primary 어노테이션을 사용하면 우선권을 가진다. */
@Repository
public class BookMySqlRepository implements BookRepository {

    @Override
    public void saveBook() {
        System.out.println("MySql");
    }
}
