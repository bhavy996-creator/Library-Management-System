class Book {
    int bookid;
    String title;
    String author;
    Boolean isIssued;
    String issuedTo;

    Book(int bookid, String title, String author){
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = null;

    }
    void display(){
        System.out.println(bookid + "|" + title + "|" + author + "|" + (isIssued ? "Issued to " + issuedTo : "Available" ));
    }


}
