public interface UsersList {
    User[] getUsers();
    void addUser(User user);
    User getUserByID(Integer id) throws UserNotFoundException;
    User getUserByIndex(Integer index);
    Integer getNbrUsers();
};