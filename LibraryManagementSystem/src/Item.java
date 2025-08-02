import java.time.LocalDate;

public class Item {
    private String title;
    private String author;
    private boolean isAvailable = true;
    private TYPE type;
    private LocalDate borrowDate;
    private Member borrowedBy;

    public Item(String title, String author, TYPE type){
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void markBorrowed(Member member){
        this.isAvailable = false;
        this.borrowDate = LocalDate.now();
        this.borrowedBy = member;
    }

    public void markReturned(){
        this.isAvailable = true;
        this.borrowedBy = null;
        this.borrowDate = null;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " is Available." : " is Borrowed.");
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }

    public void setBorrowDate(LocalDate date) {
        borrowDate = date;
    }
}
