// File: Track.java
package hust.soict.hedspi.aims.media;

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
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) return false;
        Track other = (Track) o;
        return this.title.equals(other.getTitle()) && this.length == other.getLength();
    }
}