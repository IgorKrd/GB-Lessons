package backpackTask;

public class Goods {

    private  int weight;
    private  int value;
    private  String name;

    public Goods(int weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
