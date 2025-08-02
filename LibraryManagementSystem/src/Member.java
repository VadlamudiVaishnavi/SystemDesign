import java.util.ArrayList;
import java.util.List;

public class Member implements Account{
    protected String name;
    protected String password;
    protected List<Item> borrowedItems;
    double penaltyIncurred;
    public Member(String name){
        this.name = name;
        borrowedItems = new ArrayList<>();
        penaltyIncurred=0.0;
    }

    public void addPenalty(double penaltyIncurred){
        this.penaltyIncurred = penaltyIncurred;
    }

    public void payPenalty(double amount){
        penaltyIncurred -=amount;
    }

    public double getPenaltyIncurred(){
        return penaltyIncurred;
    }

    public String getName(){
        return name;
    }

    public List<Item> getBorrowedItems(){
        return borrowedItems;
    }

    @Override
    public String toString(){
        return "Member : "+name;
    }

    @Override
    public void resetPassword(String password) {
        this.password = password;
    }
}
