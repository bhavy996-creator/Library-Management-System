import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        
        //save file data
        void saveToFile(){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"));
                for(Book b : books){
                    writer.write(b.bookid + ", " + b.title + ", " + b.author + ", " + b.isIssued + ", " + b.issuedTo);
                    writer.newLine();

                }
                writer.close();
                System.out.println("\n...DATA SAVED TO FILE...");
            } catch (IOException e) {
                System.out.println("Error Saving File !!!");
                
            }
        }

        //load file data
        void loadfromFile(){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
                String line;
                while((line = reader.readLine()) != null){
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    String author = data[2];
                    boolean isIssued = Boolean.parseBoolean(data[3]);
                    String issuedTo = data[4];

                    Book b = new Book(id, title, author);
                    b.isIssued = isIssued;
                    b.issuedTo = issuedTo.equals("null")?null : issuedTo;

                    books.add(b);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("No data found!!!");
            }
        }

        //delete block
        void deleteBook(int id){
            Book b = findBookbyid(id);
            if(b == null){
                System.out.println("No record found");
                return;
            }
            books.remove(b);
            System.out.println("\n...Details removed succesfully...");
        }

        //update block
        void updateBook(int id, String newtitle, String newauthor){
            Book b = findBookbyid(id);
            if(b == null){
                System.out.println("No record found");
                return;
            }
            b.title = newtitle;
            b.author = newauthor;
            System.out.println("\n...Details update succesfully...");
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

