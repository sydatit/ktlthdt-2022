package prepare.interview.oop.functional_interface;

public class Main {
    public static void main(String[] args) {
        // basic
        Bird something = new Bird();
        something.tryFlying(new Chicken());

        // use anonymous class
        Flyable chicken = new Flyable() {
            @Override
            public void fly() {
                System.out.println("Chicken is flying ...");
            }
        };

        // after java 8
        Flyable bird = () -> System.out.println("Bird is flying ...");
        something.tryFlying(bird);

        something.tryFlying(() -> System.out.println("Bird is flying ..."));

        // method references
        something.tryFlying(Airport::takeOffAPlane);


    }
}
