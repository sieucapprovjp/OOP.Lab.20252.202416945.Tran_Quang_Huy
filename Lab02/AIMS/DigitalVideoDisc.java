public class DigitalVideoDisc {
    // Section 16: classifier member (static)
    private static int nbDigitalVideoDiscs = 0;
    // Section 16: instance member
    private int id;
    // Section 8: attributes
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    // Section 10: constructors (method overloading)
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title=title;
        this.category=category;
        this.director=director;
        this.cost=cost;
        nbDigitalVideoDiscs++;
        this.id=nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Section 9: getters only
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    // Section 15: temporary setter for title
    public void setTitle(String title) {
        this.title = title;
    }
    public void playDVD() {
        if (this.length <= 0) {
            System.out.println("The DVD \"" + title + "\" cannot be played.");
        } else {
            System.out.println("Playing DVD: " + title + " (" + length + " mins)");
        }
    }
    public void displayInfo() {
        System.out.println("  ID: " + id + " | Title: " + title
                + " | Category: " + category
                + " | Director: " + director
                + " | Length: " + length + " mins"
                + " | Cost: " + cost);
    }
}