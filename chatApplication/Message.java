
public class Message {
    private final String senderId;
    private final String receiverId;
    private final String content;
    private final long timestamp;

    public Message(String senderId, String receiverId, String content, long timestamp){
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSenderId(){
        return senderId;
    }
    public String getReceiverId(){
        return receiverId;
    }
    public String getContent(){
        return content;
    }
    public long getTimestamp(){
        return timestamp;
    }
}
