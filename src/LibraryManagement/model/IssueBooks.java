package LibraryManagement.model;

public class IssueBooks {

    private String uniqueID, bookName, custName, dateOfIssued;

    public IssueBooks(String uniqueID, String bookName, String custName, String dateOfIssued) {
        this.uniqueID = uniqueID;
        this.bookName = bookName;
        this.custName = custName;
        this.dateOfIssued = dateOfIssued;
    }

    @Override
    public String toString() {
        return "IssuedBooks{" +
                "uniqueID='" + uniqueID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", custName='" + custName + '\'' +
                ", dateOfIssued='" + dateOfIssued + '\'' +
                '}';
    }
}
