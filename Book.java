class Book {
    int bookid;
    String title;
    String author;
    Boolean isIssued;

    Book(int bookid, String title, String author){
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.isIssued = false;

    }
    void display(){
        System.out.println(bookid + "|" + title + "|" + author + "|" + (isIssued ? "Issued" : "Available"));
    }


}
