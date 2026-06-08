package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCost implements Comparator<Media> {
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

        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        return safeTitle(m1).compareToIgnoreCase(safeTitle(m2));
    }

    private String safeTitle(Media media) {
        return media.getTitle() == null ? "" : media.getTitle();
    }
}
