package LibraryManagement;

import java.util.List;

public class LibraryController {

    LibraryService libraryService=new LibraryService();


    public  void addBook(Book book, int bookQuantity) {
        libraryService.addBook(book,bookQuantity);
    }
    public List<BookQuantity> viewBooks() {
        return libraryService.viewBooks();
    }
    public List<BookQuantity> searchBookByCategory(Author author) {
        return libraryService.searchBookByCategory(author);
    }
    public void deleteBook(String bookName) {
        libraryService.deleteBook(bookName);
    }
    public void issueBooks(String bookName, String custName) {
        libraryService.issueBooks(bookName,custName);
    }
    public List<IssueBooks> viewIssuedBooks() {
        return libraryService.viewIssuedBooks();
    }

}
