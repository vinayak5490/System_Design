package Library_management_system;

public class IssueRecord {
    private final String bookId;
    private final String memberId;
    private final long issueDate;

    public IssueRecord(String bookId, String memberId){
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = System.currentTimeMillis();
    }

    public String getBookId(){
        return bookId;
    }
    public String getMemberId(){
        return memberId;
    }
}
