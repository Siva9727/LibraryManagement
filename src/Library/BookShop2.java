package Library;

import java.util.*;

public class BookShop2 {
    private final HashMap<UUID,Book> table1;

    public BookShop2() {
        this.table1 = new HashMap<>();
    }

    public void addBooks(String title, String author, int year){
        Book book = new Book(title,author,year);
        table1.putIfAbsent(UUID.randomUUID(),book);
    }

    public Book getBooks(String author, String title){
        Set<UUID> key = table1.keySet();

        for (UUID k : key){
            Book a = table1.get(k);
            if (a.getAuthor().equalsIgnoreCase(author) && a.getTitle().equalsIgnoreCase(title)){
                return a;
            }

        }
        return null;
    }
    // to remove books
    public void removeBooks(String author, String title) {
        Set<UUID> key = table1.keySet();

        for (UUID k : key) {
            Book a = table1.get(k);
            if (a.getAuthor().equalsIgnoreCase(author) && a.getTitle().equalsIgnoreCase(title)) {
                table1.remove(k);
                return;
            }
        }
    }

    public List<Book> getAllBooks(){
        return new ArrayList<>(table1.values());
    }
}
