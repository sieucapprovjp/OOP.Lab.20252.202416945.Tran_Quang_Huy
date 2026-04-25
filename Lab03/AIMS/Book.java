package AIMS;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthors(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Da them tac gia:" +authorName);
        } else {
            System.out.println("Tac gia"+authorName+"da co ten tong danh sach");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Da xoa tac gia:" +authorName);
        } else {
            System.out.println("Tac gia" + authorName + "khong co ten tong danh sach");
        }
    }
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + "$ - Tác giả: " + this.authors;
    }
}
