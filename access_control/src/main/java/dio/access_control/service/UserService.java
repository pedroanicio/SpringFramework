package dio.access_control.service;

import dio.access_control.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service  //neste momento agora o Spring cuidará da existência dos objetos criados
// através da classe UserService.
public class UserService {

    private List<User> db = new ArrayList<>();

    public void insert(User user){
        System.out.println("Inserting user.");
        db.add(user);
    }
    public void modify(User user){
        System.out.println("Modifying user");
        int index = db.indexOf(user);
        db.set(index,user);
    }
    public User searchByUsername(String username){
        System.out.println("Searching for username");
        int index = db.indexOf(new User(username));
        User selectUser = db.get(index);
        return selectUser;
    }
    public List<User> list(){
        return db;
    }
}
