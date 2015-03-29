

package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;


public class FileUserDao implements UserDao {
    private File userInformation;
    private List<User> userList;

    public FileUserDao(File userInformation) {
        this.userInformation = userInformation;
        createUserList();
    }

    private void createUserList() {
        userList = new ArrayList<User>();
        Scanner s = null;
        try {
            s = new Scanner(userInformation);
        } catch (FileNotFoundException ex) {}
        while(s.hasNext()) {
            userList.add(new User(s.next(), s.next()));
        }
    }
    
    @Override
    public List<User> listAll() {
        return userList;
    }

    @Override
    public User findByName(String name) {
        for (User u : userList) {
            if(u.getUsername().equals(name)) return u;
        }
        return null;
    }

    @Override
    public void add(User user) {
        FileWriter writer = null;
        
        try {
            writer = new FileWriter(userInformation, true);
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userList.add(user);
        try {
            writer.append(user.getUsername());
            writer.append("\n");
            writer.append(user.getPassword());
            writer.append("\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
