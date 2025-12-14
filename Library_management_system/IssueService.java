package Library_management_system;
import java.util.*;
public class IssueService {
    private final Map<String, IssueRecord> issuedBooks = new HashMap<>();

    public boolean issueBook(Book book, Member member){
        if(!book.isAvailable()) return false;
        book.issue();
        issuedBooks.put(book.getBookId(), new IssueRecord(book.getBookId(), member.getMemberId()));
        return true;
    }

    public boolean returnBook(Book book){
        if(!issuedBooks.containsKey(book.getBookId())) return false;
        book.returned();
        issuedBooks.remove(book.getBookId());
        return true;
    }
}
