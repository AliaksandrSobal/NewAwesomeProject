package by.alex.storage;

import by.alex.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage implements UserStorage {

    private List<User> users = new ArrayList<>();


    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public String updateLogin(String login, long id) {
        for (User user : users) {
            if (user.getId() == id) {
                String login1 = user.getLogin();
                user.setLogin(login);
                return login1;
            }
        }
        return null;
    }

    @Override
    public String updateName(String name, long id) {
        for (User user : users) {
            if (user.getId() == id) {
                String newName = user.getName();
                user.setName(name);
                return newName;
            }
        }
        return null;

    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User removeById(long id) {
        for (User user : users) {
           if(user.getId()== id){
               User user1 = user;
               users.remove(user);
               return user1;
           }
        }
        return null;
    }

    @Override
    public String updatePassword(long id, String password) {
        for (User user : users) {
            if (user.getId() == id) {
                String newPassword = user.getPassword();
                user.setPassword(password);
                return newPassword;
            }
        }
        return null;
    }

    @Override
    public User getById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }

        }
        return null;


    }


    @Override
    public User getByName(String name) {
        for (User user : users) {
            if(user.getName().equals(name) ){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (User user : users) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
