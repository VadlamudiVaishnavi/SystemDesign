import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Item> items = new ArrayList<Item>();
    List<Member> members = new ArrayList<>();

    List<Item> getItems(){
        return items;
    }

    List<Member> getMembers(){
        return members;
    }

}
