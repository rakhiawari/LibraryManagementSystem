package LibraryManagement;

import LibraryManagement.model.Book;

public class UserList {

    private String userName;
    private Book book;

    public UserList(String userName, Book book) {
        this.userName = userName;
        this.book = book;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userName='" + userName + '\'' +
                ", book=" + book +
                '}';
    }
}
