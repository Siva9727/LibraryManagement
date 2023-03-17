package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShop {
    static Scanner in = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/library";
    String uname = "root";
    String pass = "Siva9727@";
    Connection con;
    public void establishConnection() throws Exception {
        // load and register
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,uname,pass);
    }

    // add books in database
    public void addBooks(String title, String author, int year) throws Exception {

        String query = "insert into booklist(author_name,book_title,yearOfPublish) values(?,?,?);";
//
        // load and register
        establishConnection();

        // check if the book is already in db
        PreparedStatement check = con.prepareStatement("SELECT * FROM bookList WHERE LOWER(book_title) = ? && LOWER(author_name) = ? && yearOfPublish = ?;") ;
        check.setString(1,title);
        check.setString(2,author);
        check.setInt(3,year);
        // execute

        ResultSet rs = check.executeQuery();
        if (rs.next()){
            System.out.println("Book already exist in database");
        }
        else {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,author.toLowerCase());
            st.setString(2,title.toLowerCase());
            st.setInt(3,year);

            st.executeUpdate();
            System.out.println("Book added in Database");
            st.close();
        }

        check.close();
        rs.close();
        con.close();


    }

    // remove books

    public void removeBooks() throws Exception {
        String query = "delete from booklist where book_title = ?;";
        System.out.println("Enter Book title");
        String title =in.nextLine();

        // establish connection
        establishConnection();

        // first check the book is listed on db or not ?

        PreparedStatement check = con.prepareStatement("SELECT * FROM booklist WHERE book_title = ?");
        check.setString(1,title.toLowerCase());
        ResultSet rs = check.executeQuery();

        if (!rs.next()){
            System.out.println("Book not available");
            return;
        }

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,title.toLowerCase());

        // execute update
        st.executeUpdate();
        System.out.println("rows affected");

        rs.close();
        con.close();
        check.close();
    }

    // list all books

    public List<Book> getAllBooks() throws Exception{
        String query = "select * from booklist;";
        //set connection
        establishConnection();

        //prepare statement
        PreparedStatement st = con.prepareStatement(query);

        // execute query
        ResultSet rs = st.executeQuery();

        // create a list of books to store data
        List<Book> books = new ArrayList<>();
        //iterate over
        while (rs.next()){
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            int year = rs.getInt("yearOfPublish");
            Book book = new Book(title,author,year);
            books.add(book);
        }
        st.close();
        rs.close();
        con.close();

        return books;
    }

    // search for books
    public void searchBook() throws Exception{
        System.out.println("Enter name of the book ?");
        String title = in.nextLine();
        System.out.println("Enter name of the author ?");
        String author = in.nextLine();

        String query = "SELECT * FROM bookList WHERE LOWER(author_name) = ? && LOWER(book_title) = ?;";

        // establish connection
        establishConnection();

        // prepare statement
        PreparedStatement check = con.prepareStatement(query);
        check.setString(1,author);
        check.setString(2,title);

        // execute query
        ResultSet rs = check.executeQuery();

        // check condition
        if (rs.next()){
            System.out.println("Book found");
            System.out.println("title : "+rs.getString("book_title"));
            System.out.println("Author Name : "+rs.getString("author_name"));
            System.out.println("Year : "+rs.getInt("yearOfPublish"));
        }
        else {
            System.out.println("Book not found");
        }
    }

    // for sorting the list by title and author name

    public void sortedList() throws Exception{
        //string query
        String query = "select * from booklist order by book_title,author_name;";

        // establish connection
        establishConnection();

        // prepare statement
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        // iterate over the result
        System.out.println("Sorted list of books ");
        while (rs.next()){
            String title = rs.getString("book_title");
            String author = rs.getString("author_name");
            int year = rs.getInt("yearOfPublish");
            System.out.println(title+" : "+ author+" : " + year);
        }
        rs.close();
        st.close();
        con.close();
    }

    // to filter
    public void filterBook(char c) throws Exception{
        char lowerC = Character.toLowerCase(c);

        String query = "select * from booklist where book_title like ? order by book_title, author_name ;";
        // establish connection
        establishConnection();

        // prepare statement
        PreparedStatement st = con.prepareStatement(query);
        // set values
        st.setString(1,lowerC+"%");

        // execute query
        ResultSet rs = st.executeQuery();
        // filtered list
        System.out.println("filtered list ");
        while (rs.next()){
            String title = rs.getString("book_title");
            String author = rs.getString("author_name");
            int year = rs.getInt("yearOfPublish");
            System.out.println(title+" : "+author+" : "+year);
        }
        rs.close();
        st.close();
        con.close();
    }

    // to update a row values in database
    // modify book author, title, and/or year of publish
    public void updateBook() throws Exception {
        String query = "UPDATE booklist SET author_name = ?, book_title = ?, yearOfPublish = ? WHERE book_id = ?;";

        // prompt user for book ID and new values
        System.out.println("Enter the ID of the book you wish to modify:");
        int id = in.nextInt();
        in.nextLine(); // consume newline
        System.out.println("Enter the new author name (leaving the space will store null values):");
        String author = in.nextLine();
        System.out.println("Enter the new book title (leaving the space will store null values):");
        String title = in.nextLine();
        System.out.println("Enter the new year of publish (leaving the space will store null values):");
        String yearString = in.nextLine();
        Integer year = null;
        if (!yearString.isBlank()) {
            year = Integer.parseInt(yearString);
        }

        // establish connection
        establishConnection();

        // prepare and execute statement
        PreparedStatement st = con.prepareStatement(query);
        if (!author.isBlank()) {
            st.setString(1, author);
        } else {
            st.setNull(1, Types.VARCHAR);
        }
        if (!title.isBlank()) {
            st.setString(2, title);
        } else {
            st.setNull(2, Types.VARCHAR);
        }
        if (year != null) {
            st.setInt(3, year);
        } else {
            st.setNull(3, Types.INTEGER);
        }
        st.setInt(4, id);
        int rowsAffected = st.executeUpdate();

        // print number of rows affected
        System.out.println(rowsAffected + " rows affected.");

        // close statement and connection
        st.close();
        con.close();
    }

}


