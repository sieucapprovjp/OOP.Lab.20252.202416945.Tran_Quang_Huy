package AIMS;

public class Store {
    public static final int MAX_NUMBERS_STORED = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_STORED];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore == MAX_NUMBERS_STORED) {
            System.out.println("The store is full. Cannot add: " + dvd.getTitle());
            return;
        }
        itemsInStore[qtyInStore] = dvd;
        qtyInStore++;
        System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" is not in the store.");
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.printf("%d. %s%n", (i + 1), itemsInStore[i].toString());
        }
        System.out.println("Total items in store: " + qtyInStore);
        System.out.println("***************************************************");
    }

    public int getQtyInStore() {
        return qtyInStore;
    }
}
