package Library;

public class Book {
    private final String title;
    private final String author;
    private final int yearOfPublish;
    public  Book(String title,String author, int yearOfPublish){
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;

    }
//    add methods to get the book details
    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public int getYearOfPublish(){
        return yearOfPublish;
    }

    public void display(){
        System.out.print("title: "+this.title);
//        System.out.println();
        System.out.print("--> author: " +this.author);
//        System.out.println();
        System.out.print("-->Year of Publish: " + this.yearOfPublish);
        System.out.println();
    }


}