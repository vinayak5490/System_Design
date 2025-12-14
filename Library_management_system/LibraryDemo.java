package Library_management_system;
import java.util.*;
public class LibraryDemo {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        IssueService issueService = new IssueService();

        Book b1 = new Book("B1", "Clean Code", "Robert Martin");
        Book b2 = new Book("B2", "Effective Java", "Joshua Bloch");

        bookService.addBook(b1);
        bookService.addBook(b2);

        Member m1 = new Member("M1", "Alice");
        memberService.registerMember(m1);

        issueService.issueBook(b1, m1);
        System.out.println(b1.isAvailable()); // false

        issueService.returnBook(b1);
        System.out.println(b1.isAvailable()); // true
    }
}
