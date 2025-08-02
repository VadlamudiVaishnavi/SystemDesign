import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryService {
    private final Library library;
    public LibraryService(Library library){
        this.library = library;
    }

    private boolean isLibrarian(Member member){
        if(!(member instanceof Librarian)){
            System.out.println("Access Denied. Reason: Only Librarians can perform this action");
            return false;
        }
        return true;
    }

    public void addItemToLibrary(Librarian librarian,Item item){
        if(!isLibrarian(librarian)) return;
        library.getItems().add(item);
        System.out.println(item.getTitle() + " Book added");
    }

    public void removeBookFromLibrary(Librarian librarian, String title){
        if(!isLibrarian(librarian)) return;
        Item item = findBookByTitle(title);
        if(item != null){
            library.getItems().remove(item);
        }
        else{
            System.out.println("No such item found");
        }
    }

    public void updateBookInfo(Librarian librarian, String oldTitle, String newTitle, String newAuthor){
        if(!isLibrarian(librarian)) return;
        Item item = findBookByTitle(oldTitle);
        if(item != null){
            item.setTitle(newTitle);
            item.setAuthor(newAuthor);
            System.out.println("Book updated!");
        }
        else{
            System.out.println("No such book found");
        }
    }

    private Item findBookByTitle(String title){
        for(Item current : library.getItems()){
            if(current.getTitle().equalsIgnoreCase(title)){
                return current;
            }
        }
        return null;
    }

}
