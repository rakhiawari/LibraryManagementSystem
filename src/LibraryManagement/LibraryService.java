package LibraryManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryService implements Library{
    List<BookQuantity> bookList = new LinkedList<>();
    List<IssueBooks> issueBooksList = new LinkedList<>();
    List<IssueBooks> returnBooksList = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook(Book book, int bookQuantity) {
        boolean flag=false;
        for (int i=0;i<bookList.size();i++) {
            if (bookList.get(i).getBook().equals(book)) {
                bookList.get(i).setBookQuantity(bookList.get(i).getBookQuantity()+bookQuantity);
                flag=true;
                break;
            }
        }
        if (flag==false) {
            bookList.add(new BookQuantity(book,bookQuantity));
        }
//        System.out.println("Added to list");
    }

    public List<BookQuantity> viewBooks() {
        return bookList;
    }

    public List<BookQuantity> searchBookByCategory(Author author) {
        List<BookQuantity> categoryList=new LinkedList<>();
        for (BookQuantity e: bookList) {
            if (e.getBook().getAuthorName().equals(author.getAuthorName())) {
                categoryList.add(e);
            }
        }
        return categoryList;
    }

    public void deleteBook(String bookName) {
        for (int i=0;i<bookList.size();i++) {
            if (bookList.get(i).getBook().getBookName().equals(bookName)) {
                bookList.remove(i);
            }
        }
    }

    public void issueBooks(String bookName, String custName) {
        for (BookQuantity e: bookList) {
            if (e.getBook().getBookName().equals(bookName)) {
                if (e.getBookQuantity() >= 1) {
                    String uniqueID = UUID.randomUUID().toString();
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    String dateOfIssue = df.format(dateobj);
                    IssueBooks thisBook = new IssueBooks(uniqueID, bookName, custName, dateOfIssue);
                    issueBooksList.add(thisBook);
                    e.setBookQuantity(e.getBookQuantity()-1);
                    return;
                }
                else {
                    deleteBook(e.getBook().getBookName());
                }
            }
        }
        System.out.println("Book not available!");
    }

    public List<IssueBooks> viewIssuedBooks() {
        return issueBooksList;
    }
}

