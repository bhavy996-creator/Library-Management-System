import java.util.*;
class Library {
    ArrayList<Book> books = new ArrayList<>();
    void addBook(Book b){
        books.add(b);
        System.out.println("Book added succesfully");
    }
    void displayBooks(){
        if(books.isEmpty()){
            System.out.println("No books record found");
            return;
        }
        for(Book b : books){
            b.display();
        }
        
    }
}
