package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    static BookShop2 a = new BookShop2();
    public static void main(String[] args) {

        

        // Added Books in bookshop


        a.addBooks("To Kill a Mockingbird","Harper Lee",1960);
        a.addBooks("1984","George Orwell", 1949);
        a.addBooks("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        a.addBooks("Pride and Prejudice","Jane Austen",1813);
        a.addBooks("One Hundred Years of Solitude","Gabriel Garcia Marquez",1967);
        a.addBooks("The Catcher in the Rye","J.D. Salinger",1951);
        a.addBooks("The Lord of the Rings","J.R.R. Tolkien",1954-1955);
        a.addBooks("Beloved","Toni Morrison",1987);
        a.addBooks("The Color Purple","Alice Walker",1982);
        a.addBooks("The Handmaid's Tale","Margaret Atwood",1985);
        a.addBooks("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997);
        a.addBooks("Harry Potter and the Chamber of Secrets","J.K. Rowling",1998);
//        a.addBooks("Harry Potter and the Prisoner of Azkaban","J.K. Rowling",1999);
//        a.addBooks("Harry Potter and the Goblet of Fire","J.K. Rowling",2000);

//        a.addBooks("To Kill a Mockingbird","Harper Lee",1960);


        System.out.println("Type 1 for search, 2 for view and 3 for filter");

        int option = in.nextInt();

        switch (option) {
            case 1 -> search();
            case 2 -> viewAllBooks();
            case 3 -> sorted();
        }




    }

    public static void sorted() {
        List<Book> result = a.getAllBooks();
        if (result.isEmpty()){
            System.out.println("Nothing to sort");
        }
        else {

        }
    }

    public static void search() {
//        BookShop2 a = new BookShop2();
//        Scanner in = new Scanner(System.in);
        System.out.println("Title of the Book ?");
        String title = in.nextLine();
        System.out.println();
        System.out.println("Name of the Author ?");
        String author = in.nextLine();

        System.out.println();

        Book book = a.getBooks(author,title);
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



    public static void viewAllBooks(){
        
        List<Book> result = a.getAllBooks();
        if (result.isEmpty()){
            System.out.println("No book is available");
        }
        else {
            for (Book n: result) {
                n.display();
            }
        }

    }
}
