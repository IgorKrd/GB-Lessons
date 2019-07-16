package Java3Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> box = new ArrayList<>();

    // метод определения веса фруктов в коробке

    public float getWeight () {

        float weight = 0.0f;

        for (T o : box) {
            weight += o.weightByEach();

        } return  weight;
    }


    // метод добавления фруктов в коробку

    public void addFruit (T fruit, int quantity) {

        for (int i = 0; i <quantity ; i++) {
            box.add(fruit);
        }
    }

    // метод для пересыпания из одной коробки в другую

    public void  pouringToBox (Box <T> anotherBox) {

        anotherBox.box.addAll(box);
        box.clear();
    }

    // метод сравнения двух коробок

    public boolean boxCompare(Box anotherBox) {

        if (getWeight() == anotherBox.getWeight()) return true;
        return false;
    }


}
