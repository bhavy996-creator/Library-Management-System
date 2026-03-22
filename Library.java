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
    void issueBooks(int id){
        for(Book b : books){
            if(b.bookid == id){
                if(!b.isIssued){
                    b.isIssued = true;
                    System.out.println("Book Issued Succesfully");
                }
                else{
                    System.out.println("Book is already issued");
                }
                return ;

            }
        }
        System.out.println("Book not found");
    }
    void returnBooks(int id){
        for(Book b : books){
            if(b.bookid == id){
                if(b.isIssued){
                    b.isIssued = false;
                    System.out.println("Book return successfully");
                }
                else{
                    System.out.println("This book was not issued");
                }
                return ;
            }
        }
        System.out.println("Book not found");
    }
}
