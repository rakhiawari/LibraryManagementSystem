package LibraryManagement.controller;

import LibraryManagement.model.Author;
import LibraryManagement.model.Book;
import LibraryManagement.model.BookQuantity;
import LibraryManagement.service.Library;

import java.util.List;
import java.util.Map;

public class LibraryController {

    Library library = Library.getInstance();


    public void addBook(Book book, int bookQuantity) {
        library.addBook(book, bookQuantity);
    }

    public List<BookQuantity> viewBooks() {
        return library.viewBooks();
    }

    public List<BookQuantity> searchBookByCategory(Author author) {
        return library.searchBookByCategory(author);
    }

    public void deleteBook(String bookName) {
        library.deleteBook(bookName);
    }

    public void issueBooks(String bookName, String custName) {
        library.issueBooks(bookName, custName);
    }

    public Map<String, List<Book>> viewIssuedBooks() {
        return library.viewIssuedBooks();
    }

}
