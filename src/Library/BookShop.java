package Library;

import java.util.HashMap;

public class BookShop {

    private final HashMap<String,Book> table;
    public BookShop(){
        this.table = new HashMap<>();
    }
    // to add book in library

    public void addBooks(String title, String author, int year){
        Book book = new Book(title,author,year);
        table.putIfAbsent(book.getTitle().toLowerCase(),book);
    }

    public Book getBooks(String title, String author){
        String k = title.toLowerCase();
        if (table.containsKey(k)){
            Book book = table.get(k);
            if (book.getAuthor().equalsIgnoreCase(author)){
                return book;
            }
        }
        return null;
    }


//    public static void main(String[] args) {
//
//        BookShop a = new BookShop();
       /*
* "To Kill a Mockingbird" by Harper Lee (1960)
"1984" by George Orwell (1949)
"The Great Gatsby" by F. Scott Fitzgerald (1925)
"Pride and Prejudice" by Jane Austen (1813)
"One Hundred Years of Solitude" by Gabriel Garcia Marquez (1967)
"The Catcher in the Rye" by J.D. Salinger (1951)
"The Lord of the Rings" by J.R.R. Tolkien (1954-1955)
"Beloved" by Toni Morrison (1987)
"The Color Purple" by Alice Walker (1982)
"The Handmaid's Tale" by Margaret Atwood (1985)
* */

//    }
}
