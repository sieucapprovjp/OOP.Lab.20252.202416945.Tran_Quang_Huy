package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements playable {

    public DigitalVideoDisc(String title) {
        super(title, null, 0.0f, 0, null);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, 0, null);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, 0, director);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            String message = "ERROR: DVD length is non-positive!";
            System.err.println(message);
            throw new PlayerException(message);
        }
        System.out.println("Playing DVD: " + this.getTitle() + " (" + this.getLength() + " mins)");
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}
