package org.mashate.performance.book;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    
    private final BookRepository bookRepository;

    
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    
    @Cacheable(value = "BookCache", key = "#id")
    public Book findBookById(Integer id) {
    	Optional<Book> bookOptional = bookRepository.findById(id);
    	if(bookOptional.isPresent()) {
    		return bookOptional.get();
    	}else return null;
		
    	
    }
    
    @Async
    public CompletableFuture<Page<Book>> findAllAsync(Pageable pageable) {
        return CompletableFuture.completedFuture(bookRepository.findAll(pageable));
    }
}