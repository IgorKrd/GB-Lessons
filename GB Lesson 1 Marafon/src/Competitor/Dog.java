package Competitor;

public class Dog extends Animal {
    public Dog(String name) {
        super("Пес", name, 500, 5, 20);
    }

    public String  getName() {
        return name;
    }
}
