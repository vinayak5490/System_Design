
import java.util.*;
public class ChatService {
    private final Map<String, ChatRoom> chatRooms = new HashMap<>();

    private String generateChatId(String u1, String u2){
        return u1.compareTo(u2) < 0 ? u1 + "_" + u2 : u2 + "_" + u1;
    }

    public void sendMessage(String senderId, String receiverId, String content){
        String chatId = generateChatId(senderId, receiverId);
        chatRooms.putIfAbsent(chatId, new ChatRoom(chatId));

        Message message = new Message(senderId, receiverId, content, System.currentTimeMillis());
        chatRooms.get(chatId).addMessage(message);
    }

    public List<Message> getChatHistory(String userA, String userB){
        String chatId = generateChatId(userA, userB);
        ChatRoom room = chatRooms.get(chatId);
        if(room == null) return Collections.emptyList();
        return room.getMessages();
    }


}
