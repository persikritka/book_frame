package tables;

public class Book {
    private int idBook;
    private String title;
    private String author;
    private int idGenre;

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIdGenre() {
        return idGenre;
    }

    private void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }
}
