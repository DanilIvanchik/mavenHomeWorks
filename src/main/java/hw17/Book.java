package hw17;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Book {
    private String author;
    private String genre;

    public Book() {}

    public Book(String author, String genre) {
        this.author = author;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String title) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
