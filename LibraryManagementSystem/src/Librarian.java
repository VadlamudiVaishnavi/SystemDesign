public class Librarian extends Member{
    public Librarian(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return "Librarian : "+name;
    }
}
