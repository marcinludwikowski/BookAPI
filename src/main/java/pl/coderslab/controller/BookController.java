package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.beans.Book;
import pl.coderslab.beans.BookService;
import pl.coderslab.beans.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;


    public BookController() {
        }

    public BookController(BookService bookService) {
            this.bookService = bookService;
        }



        @GetMapping("")
        @ResponseBody
        public
        List<Book> getList() {
            return bookService.getBooks();
        }
    }
