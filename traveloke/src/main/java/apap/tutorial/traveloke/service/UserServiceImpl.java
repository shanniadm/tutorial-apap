package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override 
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public void updatePassword(UserModel user, String pass){
        String passFinal = encrypt(pass);
        user.setPassword(passFinal);
    }

    @Override
    public UserModel findUser(String username){
        return userDb.findByUsername(username);
    }

    @Override 
    public Boolean validatePass(String pass){
        if(pass.length()<8){
            return false;
        } else {
            int jumlahAngka = 0;
            int jumlahHuruf = 0;
            for(int i=0; i<pass.length(); i++){
                try{
                    int angka = Integer.parseInt(String.valueOf(pass.charAt(i)));
                    jumlahAngka++;
                } catch (NumberFormatException e) {
                    jumlahHuruf++;
                }
            }
            if(jumlahAngka>0 && jumlahHuruf>0){
                return true;
            } else {
                return false;
            }
        }
    }
}
