package models;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String toJsonString(boolean excludeID){
        if(excludeID){
            return "{ \"title\": \"" + this.title + "\", \"author\": \"" + this.author + "\" }";
        }else{
            return "{ \"id\": \"" + this.id + "\", \"title\": \"" + this.title + "\", \"author\": \"" + this.author + "\" }";
        }
    }
}

