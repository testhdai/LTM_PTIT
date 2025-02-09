package RMI;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 20241123L;
    public String id;
    public String title;
    public String author;
    public int yearPublished;
    public int pageCount;
    public String code;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                ", code='" + code + '\'' +
                '}';
    }
}
