package apap.tutorial.traveloke.service;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    void updatePassword(UserModel user, String password);
    UserModel findUser(String username);
    Boolean validatePass(String pass);
}
