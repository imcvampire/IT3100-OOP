package mediaone;

public class Book extends Product {
    private String author;
    private String publisher;

    public Book(String name, int quantity, int price, String author, String publisher) {
        super(name, quantity, price);

        setAuthor(author);
        setPublisher(publisher);
    }

    public String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
