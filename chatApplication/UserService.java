
import java.util.*;
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public void registerUser(String userId, String name){
        if(users.containsKey(userId)){
            throw new IllegalArgumentException("User already exists");
        }
        users.put(userId, new User(userId, name));
    }

    public User getUser(String userId){
        return users.get(userId);
    }
}
