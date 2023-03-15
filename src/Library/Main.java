package Library;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BookShop2 books = new BookShop2();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        // add books here

        books.addBooks("To Kill a Mockingbird", "Harper Lee", 1960);
        books.addBooks("1984", "George Orwell", 1949);
        books.addBooks("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        books.addBooks("Pride and Prejudice", "Jane Austen", 1813);
        books.addBooks("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1967);
        books.addBooks("The Catcher in the Rye", "J.D. Salinger", 1951);
        books.addBooks("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        books.addBooks("Beloved", "Toni Morrison", 1987);
        books.addBooks("The Color Purple", "Alice Walker", 1982);
        books.addBooks("The Handmaid's Tale", "Margaret Atwood", 1985);
        books.addBooks("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        books.addBooks("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
        books.addBooks("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999);
        books.addBooks("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000);
        books.addBooks("Angela's Ashes", "Frank McCourt", 1996);
        books.addBooks("Angela's Ashes", "Anna", 1996);




        System.out.println("select \n1 for search \n2 for view all books \n3 for sorted book titles \n4 for filter book titles");

        int n = in.nextInt();
        System.out.println(n);
        switch (n) {
            case 1 -> {
                System.out.println("enter name of the book?");
                in.nextLine();
                String title = in.nextLine().trim();
                System.out.println("enter author's name ?");
                String author = in.nextLine().trim();
                search(author, title);
            }
            case 2 -> viewAllBooks();
            case 3 -> sortedList();
            case 4 -> {
                System.out.println("Enter the character between A to Z");
                char c = in.next().trim().charAt(0);
                filter(c);
            }
            default -> System.out.println("Invalid option");
        }


    }



    // to filter

    private static void filter(char c) {
        List<Book> list = books.getAllBooks();
        List<Book> names;
        names = list.stream()
                .filter(book -> book.getTitle().charAt(0)==Character.toLowerCase(c) || book.getTitle().charAt(0) == Character.toUpperCase(c))
                .collect(Collectors.toList());
        for (Book a: names){
            System.out.println(a.getTitle()+" : "+ a.getAuthor());
        }

    }

    // to sort

    private static void sortedList() {
        List<Book> list = books.getAllBooks();
        List<Book> names;
        names = list.stream()
                .sorted(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor))
                .collect(Collectors.toList());
        for (Book a : names){
            System.out.println(a.getTitle()+" : "+ a.getAuthor() + " : "+a.getYearOfPublish());
        }
    }

    // to get all books

    public static void viewAllBooks() {
        List<Book> list = books.getAllBooks();
        list.forEach(Book::display);
    }

    // to search

    public static void search(String author, String title) {
        List<Book> list = books.getAllBooks();
        List<Book> names;
        names = list.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author) && book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        for (Book a : names){
            a.display();
        }
    }


}
