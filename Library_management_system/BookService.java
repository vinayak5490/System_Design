package Library_management_system;
import java.util.*;
public class BookService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book){
        books.put(book.getBookId(), book);
    }

    public Book getBookById(String bookId){
        return books.get(bookId);
    }

    public List<Book> searchByTitle(String title){
        List<Book> result = new ArrayList<>();
        for(Book book : books.values()){
            if(book.getTitle().equalsIgnoreCase(title)){
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author){
        List<Book> result = new ArrayList<>();
        for(Book book : books.values()){
            if(book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }
        return result;
    }
}
