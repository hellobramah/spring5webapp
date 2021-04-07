package guru.springframework.spring5webapp.Controllers;


import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    //enhance model with list of books
    private final BookRepository bookRepository;
    //inject a book repository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //request mapping to book path
    @RequestMapping("/books")
    //pass model as parameter
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        //return to view
        return "books";
    }
}
