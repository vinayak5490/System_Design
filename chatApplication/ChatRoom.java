
import java.util.*;
public class ChatRoom {
    private final String chatId;
    private final List<Message> messages;

    public ChatRoom(String chatId){
        this.chatId = chatId;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }
    public List<Message> getMessages(){
        return messages;
    }
}
