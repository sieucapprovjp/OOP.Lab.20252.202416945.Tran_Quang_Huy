package AIMS;

public class StoreTest {
    public static void main(String[] args) {
        // Create a store
        Store store = new Store();

        // Create sample DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 90, 20.99f);

        // Test addDVD()
        System.out.println("=== Test addDVD() ===");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display store
        System.out.println("\n=== Display Store ===");
        store.displayStore();

        // Test removeDVD()
        System.out.println("\n=== Test removeDVD() ===");
        store.removeDVD(dvd2);

        // Display store after removal
        System.out.println("\n=== Display Store After Removal ===");
        store.displayStore();

        // Test removing a DVD not in store
        System.out.println("\n=== Test removeDVD() - Not in Store ===");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 15.99f);
        store.removeDVD(dvd4);

        System.out.println("\n=== All Tests Completed ===");
    }
}
