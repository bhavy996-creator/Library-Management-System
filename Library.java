import java.util.*;
class Library {
    ArrayList<Book> books = new ArrayList<>();
    //avoid duplicate add bookings
    void addBook(Book b){
        for(Book existing : books){
            if(existing.bookid == b.bookid){
                System.out.println("Book already exists!");
                return;
            }
        }
        books.add(b);
        System.out.println("Book added succesfully");
    }
    //avoid manual search logic 
    Book findBookbyid(int id){
        for(Book b : books){
            if(b.bookid == id){
                return b;
            }
        }
        return null;
    }

    //issuebook
    void issueBooks(int id, String username){
        Book b = findBookbyid(id);
        if(b == null){
            System.out.println("Book not found");
            return ; 
        }
                if(!b.isIssued){
                    b.isIssued = true;
                    b.issuedTo = username;
                    System.out.println("Book Issued to " + username);
                }
                else{
                    System.out.println("Book is already issued to " + b.issuedTo);
                }
            }
    void returnBooks(int id){
        Book b = findBookbyid(id);
        if(b == null){
            System.out.println("Book not found !!");
            return ;
        }
                if(b.isIssued){
                    System.out.println("Book returnend from " + b.issuedTo);
                    b.isIssued = false;
                    b.issuedTo = null;
                    
                }
                else{
                    System.out.println("This book was not issued");
                }

            
        }
            //display books
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

