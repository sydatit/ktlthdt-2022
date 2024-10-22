package prepare.interview.oop.abstraction;

public class Person {
    private String name;
    private int age;
    private float height;

    public Person(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ( 0 <= age && age <= 100) {
            this.age = age;
        }
    }

    public void setAge(byte age) {
        if ( 0 <= age && age <= 100) {
            this.age = age;
        }
    }

    public void setAge(short age) {
        if ( 0 <= age && age <= 100) {
            this.age = age;
        }
    }

    public void getInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Height: " + this.height);
    }
}
