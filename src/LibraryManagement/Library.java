package LibraryManagement;

import java.util.List;

public interface Library {
    public void addBook(Book b,int bookQuantity);
    public List<BookQuantity> viewBooks();
    public List<BookQuantity> searchBookByCategory(Author author);
    public void deleteBook(String bookName);
    public void issueBooks(String bookName, String custName);
    public List<IssueBooks> viewIssuedBooks();
//    public void returnBook(String custName, String bookName);

}
