package backpackTask;


public class Backpack {
    static final int MAX_WEIGHT = 7;         // принимаем вместимость рюкзака равной 7 кг.

    static Goods[] goods = {
            new Goods(1, 600, "Книга"), // Книга вес 1 кг. стоимость 600
            new Goods(2, 5000, "Бинокль"),  // Бинокль вес 2 кг. стоимость 5000
            new Goods(4, 1500, "Аптечка"),  // Аптечка вес 4 кг. стоимость 1500
            new Goods(2, 40000, "Ноутбук"), // Ноутбук вес 2 кг. стоимость 40000
            new Goods(1, 500, "Котелок")  // Котелок вес 1 кг. стоимость 500
    };


    public static void main(String[] args) {

        System.out.println("Стоимость набора вещей в рюкзаке: " + findBestSetCost(goods.length - 1, MAX_WEIGHT));

    }

    private static int findBestSetCost(int i, int weight) {

        if (i < 0) {
            return 0;
        }
        if (goods[i].getWeight() > weight) {

            return findBestSetCost(i - 1, weight);
        } else {

            int max = Math.max(findBestSetCost(i - 1, weight), findBestSetCost(i - 1, weight - goods[i].getWeight()) + goods[i].getValue());
            return max;
        }
    }
}



