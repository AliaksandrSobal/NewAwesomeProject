package by.alex.storage;

import by.alex.domain.User;

import java.util.List;

public interface UserStorage {
    boolean save(User user);
    String  updateLogin(String login, long id);
    String updateName(String name, long id);
    List<User> getAll();
    User removeById(long id);
    String updatePassword(long id,String name);
    User getById(long id);
    User getByName(String name);
    User getByLogin(String login);

}
