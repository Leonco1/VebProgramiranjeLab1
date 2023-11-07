package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Author> authors;
    public static List<Book> books;
    @PostConstruct
    public void init()
    {
        authors=new ArrayList<>();
        books=new ArrayList<>();
        authors.add(new Author(1L,"George","Martin","Mylife"));
        authors.add(new Author(2L,"JK","Rowling","HarryPotter"));
        authors.add(new Author(3L,"George","Orwell","asdsadsad"));
        authors.add(new Author(4L,"William","Shakespear","Romeo"));
        authors.add(new Author(5L,"Stephen","King","IT"));


        ArrayList<Author> authors1 = new ArrayList<>();
        authors1.add(new Author(6L, "John", "Smith", "Book 1"));
        authors1.add(new Author(7L, "Jane", "Doe", "Book 2"));

        ArrayList<Author> authors2 = new ArrayList<>();
        authors2.add(new Author(8L, "Alice", "Johnson", "Book 3"));
        authors2.add(new Author(9L, "Bob", "Williams", "Book 4"));

        ArrayList<Author> authors3 = new ArrayList<>();
        authors3.add(new Author(10L, "Eleanor", "Davis", "Book 5"));
        authors3.add(new Author(11L, "Frank", "Brown", "Book 6"));

        ArrayList<Author> authors4 = new ArrayList<>();
        authors4.add(new Author(12L, "Grace", "Miller", "Book 7"));
        authors4.add(new Author(13L, "Henry", "White", "Book 8"));

        ArrayList<Author> authors5 = new ArrayList<>();
        authors5.add(new Author(14L, "Isabella", "Harris", "Book 9"));
        authors5.add(new Author(15L, "Jack", "Lee", "Book 10"));

        books.add(new Book("123","Harry Potter","Magic",1990,authors1));
        books.add(new Book("1234","A song Of Ice and Fire","Fantasy",1995,authors2));
        books.add(new Book("1223","The Unbearable Lightness of Being","Novel",1984,authors3));
        books.add(new Book("1111","1984","Dystopia",1949,authors4));
        books.add(new Book("11113","The Trial","Novel",1925,authors5));
    }

}
