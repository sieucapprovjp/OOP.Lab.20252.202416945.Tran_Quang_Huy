package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }

    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getCategory() { return category; }
    public float getCost()      { return cost; }

    public void setTitle(String title)       { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost)          { this.cost = cost; }

    public boolean isMatch(String keyword) {
        if (keyword == null || this.title == null) return false;
        return this.title.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return equalsIgnoreCase(this.title, other.title)
                && Float.compare(this.cost, other.cost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title == null ? null : title.toLowerCase(), cost);
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            return 1;
        }
        return COMPARE_BY_TITLE_COST.compare(this, other);
    }

    private static boolean equalsIgnoreCase(String first, String second) {
        if (first == null) {
            return second == null;
        }
        return first.equalsIgnoreCase(second);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitle();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCost();

    @Override
    public abstract String toString();
}
