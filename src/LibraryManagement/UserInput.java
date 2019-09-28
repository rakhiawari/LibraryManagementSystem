package LibraryManagement;

import LibraryManagement.controller.LibraryController;
import LibraryManagement.model.Author;
import LibraryManagement.model.Book;

import java.util.Scanner;
import java.util.UUID;

public class UserInput {

    public static void main(String[] args) {

        LibraryController libraryController = new LibraryController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String tempName;
        do {
            System.out.println("1.Add Books to Library\n2.View Book List in Library\n3.View Books by Category(Author " +
                    "Name)\n4.Issue Book\n5.View Issued Books\n6.Delete Book from Library\n7.Logout!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter book name:");
                    scanner.nextLine();
                    String bookName = scanner.nextLine();
                    System.out.println("Enter author name");
                    tempName = scanner.nextLine();
                    Author authorName = new Author(tempName);
                    System.out.println("Enter book quantity");
                    int bookQuantity = scanner.nextInt();
                    String uniqueID = UUID.randomUUID().toString();
                    Book book = new Book(uniqueID, bookName, authorName);
                    libraryController.addBook(book, bookQuantity);
                    break;
                case 2:
                    libraryController.viewBooks().stream().forEach(e -> System.out.println(e));
                    break;
                case 3:
                    System.out.println("Enter Author name: ");
                    scanner.nextLine();
                    tempName = scanner.nextLine();
                    authorName = new Author(tempName);
                    libraryController.searchBookByCategory(authorName).stream().forEach(e -> System.out.println(e));
                    break;
                case 4:
                    System.out.println("Enter book name: ");
                    scanner.nextLine();
                    bookName = scanner.nextLine();
                    System.out.println("Enter customer name: ");
                    String custName = scanner.nextLine();
                    libraryController.issueBooks(bookName, custName);
                    break;
                case 5:
                    libraryController.viewIssuedBooks().forEach((k, v) -> System.out.println((k + ":" + v)));
                    break;
                case 6:
                    System.out.println("Enter book name to be deleted: ");
                    scanner.nextLine();
                    bookName = scanner.nextLine();
                    libraryController.deleteBook(bookName);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("INVALID choice.");
            }
        } while (choice != 7);

    }
}
