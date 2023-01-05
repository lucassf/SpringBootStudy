package br.com.fiap.spring.service;

import br.com.fiap.spring.entity.BookEntity;
import br.com.fiap.spring.model.dto.BookDTO;
import br.com.fiap.spring.model.dto.CreateUpdateBookDTO;
import br.com.fiap.spring.repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private final LibraryRepository repository;

    public BookServiceImpl(LibraryRepository repository){
        this.repository = repository;
    }

    @Override
    public List<BookDTO> searchBooks(String title) {
        List<BookEntity> books;
        if (title != null){
            books = repository.searchBookByTitle(title);
        } else {
            books = repository.findAll();
        }
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

    private BookEntity findBookById(long id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public BookDTO searchById(long id) {
        return new BookDTO(findBookById(id));
    }

    @Override
    public BookDTO create(CreateUpdateBookDTO createUpdateBookDTO) {
        var book = new BookEntity(createUpdateBookDTO);
        return new BookDTO(repository.save(book));
    }

    @Override
    public BookDTO update(CreateUpdateBookDTO createUpdateBookDTO, long id) {
        var book = findBookById(id);

        book.setTitle(createUpdateBookDTO.getTitle());
        book.setDescription(createUpdateBookDTO.getDescription());
        book.setIsbn(createUpdateBookDTO.getIsbn());
        book.setPublicationDate(createUpdateBookDTO.getPublication());
        book.setPrice(createUpdateBookDTO.getPrice());

        return new BookDTO(repository.save(book));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
