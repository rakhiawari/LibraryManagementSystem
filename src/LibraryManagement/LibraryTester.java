package LibraryManagement;

import LibraryManagement.controller.LibraryController;
import LibraryManagement.model.Author;
import LibraryManagement.model.Book;

public class LibraryTester {

    public static void main(String[] args) {
        LibraryController librarycontroller=new LibraryController();

        System.out.println("Adding Books to Library!");
        Author authorName=new Author("Paulo Coelho");
        int bookQuantity=5;
        Book book1=new Book("111","The Alchemist",authorName);
        librarycontroller.addBook(book1,bookQuantity);

        bookQuantity=4;
        authorName=new Author("Paulo Coelho");
        Book book2=new Book("112","Windeye",authorName);
        librarycontroller.addBook(book2,bookQuantity);

        bookQuantity=1;
        authorName=new Author("James Joyce");
        Book book3=new Book("113","The Dead",authorName);
        librarycontroller.addBook(book3,bookQuantity);

        bookQuantity=4;
        authorName=new Author("Leo tolstoy");
        Book book4=new Book("114","War & Peace",authorName);
        librarycontroller.addBook(book4,bookQuantity);

        bookQuantity=6;
        authorName=new Author("Satanic Verses");
        Book book5=new Book("115","Salman Rushdie",authorName);
        librarycontroller.addBook(book5,bookQuantity);

        bookQuantity=2;
        authorName=new Author("Philip Pullman");
        Book book6=new Book("116","The Golden Compass",authorName);
        librarycontroller.addBook(book6,bookQuantity);
        System.out.println();

        System.out.println("List of books in a library!");
        librarycontroller.viewBooks().stream().forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("view Books By Author Name: Paulo Coelho");
        authorName=new Author("Paulo Coelho");
        librarycontroller.searchBookByCategory(authorName).stream().forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("Deleting book The Dead: ");
        librarycontroller.deleteBook("The Dead");
        System.out.println();

        System.out.println("after deleting");
        librarycontroller.viewBooks().stream().forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("issue Books: War & Peace, John Green ");
        librarycontroller.issueBooks("War & Peace","John Green");
        System.out.println();

        System.out.println("View Issued Books.");
        librarycontroller.viewIssuedBooks().forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println();

        System.out.println("issue Books: Salman Rushdie, John Green ");
        librarycontroller.issueBooks("Salman Rushdie","John Green");
        System.out.println();

        System.out.println("View Issued Books.");
        librarycontroller.viewIssuedBooks().forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println();

        librarycontroller.viewBooks().stream().forEach(e -> System.out.println(e));
        System.out.println();

    }
}
