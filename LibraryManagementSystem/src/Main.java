import sun.reflect.generics.tree.BottomSignature;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Library library = new Library();
        LibraryService libraryService = new LibraryService(library);
        MemberService memberService = new MemberService(library);
        BorrowService borrowService = new BorrowService(library);

        Librarian vaish = new Librarian("Vaish");
        Member snigdha = new Member("Snigdha");

        memberService.registerMember(vaish, vaish); //Registering myself mwahahahah
        memberService.registerMember(vaish, snigdha);

        Item whyNationsFail = new Item("Why Nations Fail", "Daron Acemoglu", TYPE.BOOK);
        Item harryFuckingPotter = new Item("Harry Potter", "Dork", TYPE.MAGAZINE);

        libraryService.addItemToLibrary(vaish, whyNationsFail);
        libraryService.addItemToLibrary(vaish, harryFuckingPotter);

        borrowService.showAvailableItems();
        borrowService.borrowBook(snigdha, "Blind Harry Potter");
        borrowService.borrowBook(snigdha, "Harry Potter");
        borrowService.showAvailableItems();

        harryFuckingPotter.setBorrowDate(LocalDate.now().minusDays(20));

        borrowService.returnBook(snigdha, "Fuck this Harry Potter");
        borrowService.returnBook(snigdha, "Harry Potter");

        memberService.wavePenalty(vaish, snigdha);

        libraryService.updateBookInfo(vaish, "Harry Potter", "Harry Potter and the Dork Stone", "J.K. Dork");

        borrowService.showAvailableItems();


    }
}
