package AIMS;
public class AIMS {

    public static void main(String[] args) {

        // Section 12: Create a new cart
        Cart anOrder = new Cart();
        // Create DVD objects and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        // Display cart and total cost
        anOrder.displayCart();

        // Section 13: Remove a DVD and display again
        System.out.println("\n--- Removing Star Wars ---");
        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.displayCart();

        // Section 14.2: Test overloading - add two DVDs at once
        System.out.println("\n--- Adding two DVDs at once ---");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 24.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Moana", "Animation", 22.99f);
        anOrder.addDigitalVideoDisc(dvd4, dvd5);
        anOrder.displayCart();

        // Section 16: Test classifier member
        System.out.println("\nTotal DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}