package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        BookShop2 a = new BookShop2();

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

//        a.addBooks("To Kill a Mockingbird","Harper Lee",1960);

        System.out.println("Title of the Book ?");
        String name = in.nextLine();
        System.out.println();
        System.out.println("Name of the Author ?");
        String author = in.nextLine();

        System.out.println();

        Book book = a.getBooks(author,name);
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
