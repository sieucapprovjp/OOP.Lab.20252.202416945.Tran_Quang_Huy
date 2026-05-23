package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private static int nbMedia =0;

    private int id;
    private String title;
    private String category;
    private float cost;
    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title, String category,float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }
    //Getter
    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getCategory() { return category; }
    public float getCost()      { return cost; }

    // Setter
    public void setTitle(String title)       { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost)          { this.cost = cost; }

    public boolean isMatch(String keyword) {
        if (keyword == null || this.title == null) return false;
        return this.title.toLowerCase().contains(keyword.toLowerCase());
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitle();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCost();

    @Override
    public abstract String toString();
}
