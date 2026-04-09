public class Cart {

    // Section 11: class constant
    public static final int MAX_NUMBERS_ORDERED = 20;
    // Section 11: attributes
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    // Section 11: add one DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add: " + disc.getTitle());
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The disc has been added. The cart is now full.");
        } else {
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        }
    }

    // Section 14.1: overload - add array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }
    // Section 14.2: overload - add two DVDs at once
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    // Section 11: remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Shift left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc \"" + disc.getTitle() + "\" is not in the cart.");
        }
    }
    // Section 11: total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    // Section 12: display cart items
    public void displayCart() {
        System.out.println("------- Current Cart -------");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d %-25s %.2f%n",
                    (i + 1),
                    itemsOrdered[i].getTitle(),
                    itemsOrdered[i].getCost());
        }
        System.out.printf("%-29s %.2f%n", "Total Cost", totalCost());
        System.out.println("----------------------------");
    }
    public int getQtyOrdered() {
        return qtyOrdered;
    }
}