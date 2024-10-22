package prepare.interview.oop.inheritance;

public class Dog extends Animal{
    String name;

    public String getInfo() {
        return name;
    }

    public String hiDog() {
        return name + " - " + age;
    }
}
