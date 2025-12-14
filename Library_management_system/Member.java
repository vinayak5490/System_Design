package Library_management_system;

public class Member {
    private final String memberId;
    private final String name;

    public Member(String memberId, String name){
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId(){
        return memberId;
    }
    public String getName(){
        return name;
    }
}
