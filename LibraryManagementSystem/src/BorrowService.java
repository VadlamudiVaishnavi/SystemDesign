import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BorrowService {
    private final Library library;
    private int MAX_BORROW_DAYS = 14;
    private double PENALTY_PER_DAY = 2.0;

    public BorrowService(Library library){
        this.library = library;
    }

    public void borrowBook(Member member, String title){
        Item item = findAvailableItemByTitle(title);
        if(item != null){
            item.markBorrowed(member);
            member.getBorrowedItems().add(item);
        }
        else{
            System.out.println("The item with title "+title+" is not available in this library");
        }
    }

    public void returnBook(Member member, String title){
        Item toReturn = null;
        for(Item borrowed : member.getBorrowedItems()){
            if(borrowed.getTitle().equalsIgnoreCase(title));
            toReturn = borrowed;
            break;
        }

        if(toReturn!=null){
            LocalDate todaysDate = LocalDate.now();
            long daysBorrowed = ChronoUnit.DAYS.between(toReturn.getBorrowDate(), todaysDate);
            if(daysBorrowed > MAX_BORROW_DAYS){
                double penalty = (daysBorrowed-MAX_BORROW_DAYS)*PENALTY_PER_DAY;
                member.setPenaltyIncurredPenalty(penalty);
                System.out.println("The member has incurred penalty fee. Please pull out your card.");
            }

            toReturn.markReturned();
            member.getBorrowedItems().remove(toReturn);
        }
        else{
            System.out.println("Book not found in the borrowed list. Free Book perhaps?");
        }
    }

    public void showAvailableItems(){
        List<Item> available = library.getItems();
        if(available.isEmpty()){
            System.out.println("No available items");
        }
        else{
            for(Item current : available){
                System.out.println(current);
            }
        }
    }

    private Item findAvailableItemByTitle(String title){
       List<Item> availableItems = library.getItems();
       for(Item current : availableItems){
           if(current.getTitle().equalsIgnoreCase(title) && current.isAvailable()){
               return current;
           }
       }
       return null;
    }


}
