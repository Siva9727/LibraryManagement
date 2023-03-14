package Library;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static BookShop2 books = new BookShop2();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        // add books here

        books.addBooks("To Kill a Mockingbird","Harper Lee",1960);
        books.addBooks("1984","George Orwell", 1949);
        books.addBooks("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        books.addBooks("Pride and Prejudice","Jane Austen",1813);
        books.addBooks("One Hundred Years of Solitude","Gabriel Garcia Marquez",1967);
        books.addBooks("The Catcher in the Rye","J.D. Salinger",1951);
        books.addBooks("The Lord of the Rings","J.R.R. Tolkien",1954-1955);
        books.addBooks("Beloved","Toni Morrison",1987);
        books.addBooks("The Color Purple","Alice Walker",1982);
        books.addBooks("The Handmaid's Tale","Margaret Atwood",1985);
        books.addBooks("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997);
        books.addBooks("Harry Potter and the Chamber of Secrets","J.K. Rowling",1998);
        books.addBooks("Harry Potter and the Prisoner of Azkaban","J.K. Rowling",1999);
        books.addBooks("Harry Potter and the Goblet of Fire","J.K. Rowling",2000);
        books.addBooks("Angela's Ashes","Frank McCourt",1996);


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


    private static void filter(char c) {
        List<Book> list = books.getAllBooks();
        ArrayList<String> name = new ArrayList<>();
        for (Book a : list){
            if (a.getTitle().charAt(0)==c || a.getTitle().charAt(0) == Character.toUpperCase(c)){
                name.add(a.getTitle());
            }
        }
        Collections.sort(name);
        for (String a : name){
            System.out.println(a);
        }

    }

    private static void sortedList() {
        List<Book> list = books.getAllBooks();
        ArrayList<String> title= new ArrayList<>();
        for (Book a : list){
            title.add(a.getTitle());
        }
        Collections.sort(title);
        for (String n:title){
            System.out.println(n);
        }
    }

    public static void viewAllBooks() {
        List<Book> list = books.getAllBooks();
        for (Book a : list){
            System.out.println(a.getTitle()+"----> written by : "+a.getAuthor());
        }
    }


    public static void search(String author, String title) {
        Book book = books.getBooks(author,title);
        if(book != null){
            book.display();
            System.out.println("How many Copies you need ?");
            int n = in.nextInt();
            System.out.println("Thanks for ordering "+n+" copy.");
        }
        else {
            System.out.println("Above mentioned book is not available");
        }
    }


}
