package br.com.fiap.spring.service;

import br.com.fiap.spring.model.dto.BookDTO;
import br.com.fiap.spring.model.dto.CreateUpdateBookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> searchBooks(String title);

    BookDTO searchById(long id);

    BookDTO create(CreateUpdateBookDTO createUpdateBookDTO);

    BookDTO update(CreateUpdateBookDTO createUpdateBookDTO, long id);

    void delete(long id);
}
