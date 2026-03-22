import java.util.*;
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;
        do {
            System.out.println("\n1.Add books");
            System.out.println("2. Display books");
            System.out.println("3. Exit");
            System.out.print("Enter choice:- ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book id:- ");
                    int bookid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title:- ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author:- ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(bookid, title, author));
                    break;
                case 2:
                    lib.displayBooks();
                    break;
                case 3:
                    System.out.println("Thanks for visiting our library!!!");  
                    break;  
                default:
                    System.out.println("INVALID CHOICE...");
                    break;
            }
        } while (choice != 3);
        sc.close();
    }
}
