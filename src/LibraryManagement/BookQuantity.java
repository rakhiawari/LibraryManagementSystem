package LibraryManagement;

public class BookQuantity {
    private Book book;
    private int bookQuantity;

    public BookQuantity(Book book, int bookQuantity) {
        this.book = book;
        this.bookQuantity = bookQuantity;
    }

    public Book getBook() {
        return book;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "" +
                "" + book +
                ", bookQuantity=" + bookQuantity + '}';
    }
}
