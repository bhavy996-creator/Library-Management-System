import java.util.*;
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        lib.loadfromFile();
        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add books");
            System.out.println("2. Display books");
            System.out.println("3. Issue Books");
            System.out.println("4. Return Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice:- ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book id:- ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title:- ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author:- ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    lib.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book Id:- ");
                    int issueid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Username:- ");
                    String username = sc.nextLine();
                    
                    lib.issueBooks(issueid, username);


                    break;  
                case 4:
                    System.out.print("Enter Book Id:- ");
                    int returnid = sc.nextInt();
                    lib.returnBooks(returnid);
                    break;
                    
                case 5:
                    lib.saveToFile();
                    System.out.println("Thanks for visiting our bank!!!");
                    break;    
                default:
                    System.out.println("INVALID CHOICE...");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
