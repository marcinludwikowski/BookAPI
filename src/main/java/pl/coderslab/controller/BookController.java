package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
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

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    }
