package Library;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class BookShop2 {
    private HashMap<UUID,Book> table1;

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
}
