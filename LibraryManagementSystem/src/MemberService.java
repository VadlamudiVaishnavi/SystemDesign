public class MemberService {

    Library library;

    public MemberService(Library library) {
        this.library = library;
    }

    public void registerMember(Librarian librarian, Member member){
        if(!isLibrarian(librarian)) return;
        library.getMembers().add(member);
        System.out.println("Member registered");
    }

    public void unregisterMember(Librarian librarian, Member member){
        if(!isLibrarian(librarian)) return;
        library.getMembers().remove(member);
        System.out.println("Member unregistered");
    }

    public void wavePenalty(Librarian librarian, Member member){
        if(!isLibrarian(librarian)) return;
        member.payPenalty(member.getPenaltyIncurred());
        System.out.println("Penalty waived");
    }

    public void extendDueDate(Librarian librarian, Member member, String title, int extraDays){
        if(!isLibrarian(librarian)) return;
        for(Item borrowed : member.getBorrowedItems()){
            if(borrowed.getTitle().equalsIgnoreCase(title)) {
                borrowed.setBorrowDate(borrowed.getBorrowDate().minusDays(extraDays));
                System.out.println("Due Date extended by " + extraDays + " days.");
                return;
            }
        }
        System.out.println("Fam, you didnt borrow an item titled this: "+title);
    }

    private boolean isLibrarian(Member member){
        if(!(member instanceof Librarian)){
            System.out.println("Access Denied. Reason: Only Librarians can perform this action");
            return false;
        }
        return true;
    }

    private void viewMemberBorrowedBooks(Librarian librarian, Member member){
        if(!isLibrarian(librarian)) return;
        System.out.println("Items borrowed by the member "+member.getName()+":");
        for(Item item : member.getBorrowedItems()){
            System.out.println("-- "+item.getTitle() + " and it's been in their possession since "+item.getBorrowDate());
        }
    }

}
