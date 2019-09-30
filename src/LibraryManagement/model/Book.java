package LibraryManagement.model;

import LibraryManagement.model.Author;

import java.util.Objects;

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
                ", authorName=" + authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return  Objects.equals(getBookName(), book.getBookName()) &&
                Objects.equals(getAuthorName(), book.getAuthorName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID, getBookName(), getAuthorName());
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName.getAuthorName();
    }

}
