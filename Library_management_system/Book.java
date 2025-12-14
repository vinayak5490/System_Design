package Library_management_system;

public class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    public void issue(){
        this.isAvailable = false;
    }
    public void returned(){
        this.isAvailable = true;
    }
}
