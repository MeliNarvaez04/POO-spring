package com.ups.poo.bootstrap;

import com.ups.poo.domain.Author;
import com.ups.poo.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ups.poo.repository.AuthorRepository;
import com.ups.poo.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData (AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book();
        book1.setTitle ("Los 3 Mosquetores");
        book1.setEditorial("Pearson");


        Book book2 = new Book();
        book2.setTitle ("Conde de Montecristo");
        book2.setEditorial("Pearson");

        Author author1 = new Author("Alejandro", "Dunas");
        author1.getBooks().add(book1);
        author1. getBooks().add(book2);

        Book book3 = new Book();
        book3.setTitle("Buscando a Alaska");
        book3.setEditorial("E. P. Dutto");

        Book book4 = new Book();
        book4.setTitle("Bajo la misma estrella");
        book4.setEditorial("Dutton Books");

        Author author2 = new Author("John", "Green");
        author2.getBooks().add(book3);
        author2.getBooks().add(book4);

        bookRepository.save(book1);
        bookRepository.save(book2);
        authorRepository.save(author1);


        bookRepository.save(book3);
        bookRepository.save(book4);
        authorRepository.save(author2);


        System.out.println("---------------------Started BootStrapData-----------");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());





    }
}
