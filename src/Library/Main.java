package Library;
/*
******************************************************************************
* ********* Check the BookShop.java file for the methods used ****************
 */

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        BookShop bookShop = new BookShop();
        Scanner in = new Scanner(System.in);
        /*
        1. "To Kill a Mockingbird", "Harper Lee", 1960
        2. "1984", "George Orwell", 1949
        3. "The Great Gatsby", "F. Scott Fitzgerald", 1925
        4. "Pride and Prejudice", "Jane Austen", 1813
        5. "One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1967
        6. "The Catcher in the Rye", "J.D. Salinger", 1951
        7. "The Lord of the Rings", "J.R.R. Tolkien", 1954
        8. "Beloved", "Toni Morrison", 1987
        9. "The Color Purple", "Alice Walker", 1982
        10. "The Handmaid's Tale", "Margaret Atwood", 1985
        11. "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997
        12. "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998
        13. "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999
        14. "Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000
        15. "Angela's Ashes", "Frank McCourt", 1996
        16.

         */
        // add books
//        bookShop.addBooks("To Kill a Mockingbird", "Harper Lee", 1960);
//        bookShop.addBooks("1984", "George Orwell", 1949);
//        bookShop.addBooks("The Great Gatsby", "F. Scott Fitzgerald", 1925);
//        bookShop.addBooks("Pride and Prejudice", "Jane Austen", 1813);
//        bookShop.addBooks("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1967);
//        bookShop.addBooks("The Catcher in the Rye", "J.D. Salinger", 1951);
//        bookShop.addBooks("The Lord of the Rings", "J.R.R. Tolkien", 1954);
//        bookShop.addBooks("Beloved", "Toni Morrison", 1987);
//        bookShop.addBooks("The Color Purple", "Alice Walker", 1982);
//        bookShop.addBooks( "The Handmaid's Tale", "Margaret Atwood", 1985);
//        bookShop.addBooks("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
//        bookShop.addBooks("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
//        bookShop.addBooks("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999);
//        bookShop.addBooks("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000);
//        bookShop.addBooks("Angela's Ashes", "Frank McCourt", 1996);

//

//        bookShop.removeBooks();
//        bookShop.sortedList();
//        bookShop.filterBook('T');
//        bookShop.addBooks("Angela", "Frank", 1996);
//        bookShop.updateBook();


        System.out.println("Select : \n1 for list all books in database \n2 for sorted list \n3 for search \n4 for filter \n5 for update the details of existing book");

        int option = in.nextInt();
        switch (option) {
            case 1 -> {
                List<Book> list = bookShop.getAllBooks();
                list.forEach(Book::display);
            }
            case 2 -> bookShop.sortedList();
            case 3 -> bookShop.searchBook();
            case 4 -> {
                System.out.println("enter the character for the filter A-Z");
                char c = in.next().trim().charAt(0);
                bookShop.filterBook(c);
            }
            case 5 -> bookShop.updateBook();
            default -> System.out.println("Invalid Options");
        }
    }

}
