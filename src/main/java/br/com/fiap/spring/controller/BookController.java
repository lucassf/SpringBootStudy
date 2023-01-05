package br.com.fiap.spring.controller;

import br.com.fiap.spring.model.dto.BookDTO;
import br.com.fiap.spring.model.dto.CreateUpdateBookDTO;
import br.com.fiap.spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> searchBooks(@RequestParam(required = false, value = "title") String title) {
        return bookService.searchBooks(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody CreateUpdateBookDTO createUpdateBookDTO) {
        return bookService.create(createUpdateBookDTO);
    }

    @PutMapping("{id}")
    public BookDTO updateBook(@PathVariable int id, @RequestBody CreateUpdateBookDTO createUpdateBookDTO) {
        return bookService.update(createUpdateBookDTO, id);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.delete(id);
    }
}
