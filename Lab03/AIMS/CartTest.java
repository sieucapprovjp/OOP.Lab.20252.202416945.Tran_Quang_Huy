package AIMS;

public class CartTest {
    public static void main(String[] args) {
        // Create sample DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 90, 20.99f);

        // Create a cart
        Cart cart = new Cart();

        // Add DVDs to cart
        System.out.println("=== Adding DVDs to Cart ===");
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // Test 1: print() method
        System.out.println("\n=== Test 1: print() method ===");
        cart.print();

        // Test 2: searchById() - existing ID
        System.out.println("\n=== Test 2: searchById() - ID = 2 ===");
        DigitalVideoDisc foundById = cart.searchById(2);
        if (foundById != null) {
            System.out.println("Found: " + foundById.getTitle());
        }

        // Test 3: searchById() - non-existing ID
        System.out.println("\n=== Test 3: searchById() - ID = 99 ===");
        DigitalVideoDisc notFoundById = cart.searchById(99);

        // Test 4: searchByTitle() - existing title (partial match)
        System.out.println("\n=== Test 4: searchByTitle() - 'Lion' ===");
        DigitalVideoDisc foundByTitle = cart.searchByTitle("Lion");
        if (foundByTitle != null) {
            System.out.println("Found: " + foundByTitle.toString());
        }

        // Test 5: searchByTitle() - non-existing title
        System.out.println("\n=== Test 5: searchByTitle() - 'Frozen' ===");
        DigitalVideoDisc notFoundByTitle = cart.searchByTitle("Frozen");

        // Test 6: isMatch() method directly
        System.out.println("\n=== Test 6: isMatch() method ===");
        System.out.println("dvd1.isMatch('Lion'): " + dvd1.isMatch("Lion"));
        System.out.println("dvd1.isMatch('lion'): " + dvd1.isMatch("lion"));
        System.out.println("dvd1.isMatch('Star'): " + dvd1.isMatch("Star"));
        System.out.println("dvd1.isMatch('The Lion King'): " + dvd1.isMatch("The Lion King"));

        // Test 7: toString() method directly
        System.out.println("\n=== Test 7: toString() method ===");
        System.out.println("dvd1.toString(): " + dvd1.toString());
        System.out.println("dvd2.toString(): " + dvd2.toString());

        // Test 8: Remove a DVD and print cart again
        System.out.println("\n=== Test 8: Remove DVD and print cart ===");
        cart.removeDigitalVideoDisc(dvd2);
        cart.print();
        System.out.println("\n=== All Tests Completed ===");
    }
}
