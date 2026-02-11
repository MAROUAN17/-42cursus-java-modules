public class UsersArrayList implements UsersList {
    private User[] userData;
    private Integer size = 10;
    
    public UsersArrayList() {
        userData = new User[10];
    }

    //methods
    public User[] getUsers() {
        return userData;
    }
    public void addUser(User user) {
        if (getNbrUsers() == size) {
            size += size / 2;
            User[] newUserData = new User[size];
            System.arraycopy(userData, 0, newUserData, 0, userData.length);
            userData = newUserData;
        }
        for(int i = 0; i < userData.length; i++) {
            if (userData[i] == null) {
                userData[i] = user; 
                break;
            }
        }
    }
    public User getUserByID(Integer id) throws UserNotFoundException {
        for(int i = 0; i < userData.length; i++) {
            if (userData[i].getID() == id) {
                return userData[i]; 
            }
        }
        throw new UserNotFoundException("Error: USER NOT FOUND");
    }
    public Integer getNbrUsers() {
        int counter = 0;
        for(int i = 0; i < userData.length; i++) {
            if (userData[i] != null) counter++;
            else break;
        }
        return counter;
    }
    public User getUserByIndex(Integer index) {
        for(int i = 0; i < userData.length; i++) {
            if (i == index) return userData[i];
        }
        return null;
    }
}