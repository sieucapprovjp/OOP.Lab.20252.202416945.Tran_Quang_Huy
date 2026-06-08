package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.Objects;

public class Track implements playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            String message = "ERROR: Track length is non-positive!";
            System.err.println(message);
            throw new PlayerException(message);
        }
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) return false;
        Track other = (Track) o;
        if (this.title == null) {
            return other.getTitle() == null && this.length == other.getLength();
        }
        return this.title.equalsIgnoreCase(other.getTitle()) && this.length == other.getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title == null ? null : title.toLowerCase(), length);
    }
}
