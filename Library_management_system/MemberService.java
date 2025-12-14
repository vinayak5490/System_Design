package Library_management_system;
import java.util.*;
public class MemberService {
    private final Map<String, Member> members = new HashMap<>();

    public void registerMember(Member member){
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId){
        return members.get(memberId);
    }
}
