package LibraryManagement.model;

import LibraryManagement.model.Author;

public class Book {
    private String uniqueID, bookName;
    private Author authorName;
    public Book(String uniqueID, String bookName, Author authorName) {
        this.uniqueID = uniqueID;
        this.bookName = bookName;
        this.authorName = authorName;

    }

    @Override
    public String toString() {
        return "Book{" +
                "uniqueID='" + uniqueID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName=" + authorName ;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName.getAuthorName();
    }

}
