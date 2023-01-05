package br.com.fiap.spring.repository;

import br.com.fiap.spring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibraryRepository extends JpaRepository<BookEntity, Long> {

    @Query("FROM BookEntity b WHERE b.title like %:title%")
    List<BookEntity> searchBookByTitle(String title);
}
