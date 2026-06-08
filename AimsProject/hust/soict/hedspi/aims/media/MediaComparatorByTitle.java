package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if (m1 == m2) {
            return 0;
        }
        if (m1 == null) {
            return -1;
        }
        if (m2 == null) {
            return 1;
        }

        int titleCompare = safeTitle(m1).compareToIgnoreCase(safeTitle(m2));
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }

    private String safeTitle(Media media) {
        return media.getTitle() == null ? "" : media.getTitle();
    }
}
