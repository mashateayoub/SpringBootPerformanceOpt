package org.mashate.performance.book;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

	
	private final  BookService bookService;

	@GetMapping
	public ResponseEntity<Page<Book>> getAllBooks( final Pageable pageable) {
		 return ResponseEntity.ok(bookService.findAll(pageable));
    }
	
	
    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable final Integer id) {
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }
	
	@GetMapping(path = "/async")
	public ResponseEntity<Page<Book>> getAllBooksAsync( final Pageable pageable) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Page<Book>> futureBooks = bookService.findAllAsync(pageable);
        return ResponseEntity.ok(futureBooks.get());
    }
	
	
	
}
