package LibraryManagement.service;

import LibraryManagement.model.Author;
import LibraryManagement.model.Book;
import LibraryManagement.model.BookQuantity;

import java.util.*;

public class Library {
    List<BookQuantity> bookList;
    Map<String, List<Book>> userList;
    static Library library = null;

    private Library() {
        bookList = new LinkedList<>();
        userList = new HashMap<>();
    }
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }
    //Adds books to the library using Linked List
    public void addBook(Book book, int bookQuantity) {
        boolean flag = false;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBook().equals(book)) {
                bookList.get(i).setBookQuantity(bookList.get(i).getBookQuantity() + bookQuantity);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            bookList.add(new BookQuantity(book, bookQuantity));
        }
    }
    //Shows books present in the library
    public List<BookQuantity> viewBooks() {
        return bookList;
    }
    //searches books by author name
    public List<BookQuantity> searchBookByCategory(Author author) {
        List<BookQuantity> categoryList = new LinkedList<>();
        for (BookQuantity e : bookList) {
            if (e.getBook().getAuthorName().equals(author.getAuthorName())) {
                categoryList.add(e);
            }
        }
        return categoryList;
    }
    //deletes books from library
    public void deleteBook(String bookName) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBook().getBookName().equals(bookName)) {
                bookList.remove(i);
            }
        }
    }
    //issues books to the customer
    public void issueBooks(String bookName, String custName) {
        List<Book> issuedBookList = new ArrayList<>();
        for (BookQuantity e : bookList) {
            if (e.getBook().getBookName().equals(bookName)) {
                if (e.getBookQuantity() >= 1) {
                    issuedBookList.add(e.getBook());
                    Set<Book> tempList = new HashSet<>(userList.get(custName) != null ? userList.get(custName) :
                            new ArrayList<>());
                    if (tempList != null && tempList.size() > 0) {
                        tempList.addAll(issuedBookList);
                        userList.put(custName, new ArrayList<>(tempList));
                    } else {
                        userList.put(custName, issuedBookList);
                    }
                    e.setBookQuantity(e.getBookQuantity() - 1);
                    return;
                } else {
                    deleteBook(e.getBook().getBookName());
                }
            }
        }
        System.out.println("Book not available!");
    }
    //shows books issued to customers
    public Map<String, List<Book>> viewIssuedBooks() {
        return userList;
    }
}

