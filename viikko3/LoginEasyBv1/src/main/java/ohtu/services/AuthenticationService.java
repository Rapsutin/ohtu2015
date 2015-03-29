package ohtu.services;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;
    
    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        return !isUsernameValid(username)|| !isPasswordValid(password);
    }
    
    private boolean isUsernameValid(String username) {
        return username.length() >= 3;
    }

    private boolean isPasswordValid(String password) {
        boolean passwordIsLongEnough = password.length() >= 8;
        boolean passwordContainsNumberOrSpecialCharacter = doesPasswordContainNonLetterCharacter(password);
        
        return passwordIsLongEnough && passwordContainsNumberOrSpecialCharacter;
    }

    private boolean doesPasswordContainNonLetterCharacter(String password) {
        boolean passwordContainsNumberOrSpecialCharacter = false;
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetter(password.charAt(i))) {
                passwordContainsNumberOrSpecialCharacter = true;
                break;
            }
        }
        return passwordContainsNumberOrSpecialCharacter;
    }

    
}
