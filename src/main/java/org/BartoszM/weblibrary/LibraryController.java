package org.BartoszM.weblibrary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("authorsList", authorRepository.findAll());
        return "index";
    }

    @PostMapping("/add-author")
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "redirect:/";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam Long authorId, @RequestParam String title) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        bookRepository.save(newBook);
        return "redirect:/";
    }
}
