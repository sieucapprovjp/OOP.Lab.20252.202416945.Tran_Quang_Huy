package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements playable {
    // 1. Constructor chỉ có title
    public DigitalVideoDisc(String title) {
        // Truyền giá trị mặc định (null, 0) cho các thuộc tính còn thiếu lên Disc
        super(title, null, 0.0f, 0, null);
    }
    // 2. Constructor có title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, 0, null);
    }
    // 3. Constructor có title, category, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, 0, director);
    }
    // 4. Constructor đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    // Ghi đè hàm play() từ interface Playable
    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("The DVD \"" + this.getTitle() + "\" cannot be played.");
        } else {
            System.out.println("Playing DVD: " + this.getTitle() + " (" + this.getLength() + " mins)");
        }
    }

    // Ghi đè hàm toString() bắt buộc
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}