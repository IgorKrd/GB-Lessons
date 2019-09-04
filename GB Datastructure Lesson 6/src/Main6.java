public class Main6 {

    public static void main(String[] args) {
        //testTree();
        int count = 0;
        int percentCount = 0;


        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new MyTreeImpl<>();
            int a = -25;
            int b = 25;

            for (int j = 0; j < 10; j++) {
                int random = rnd(a, b);
                tree.add(random);
            }
            System.out.println("Дерево под номером: " + (i + 1) + " это: " + tree);

            count += tree.checkTheBalance();
            percentCount = +i;

            tree.display();
        }

        System.out.println("Количество сбалансированных деревьев: '" + count + "', что составляет "
                + ((count * 100) / (percentCount + 1)) + " % от общего количества деревьев: '" + (percentCount + 1) + "'");
    }

    private static int rnd(int a, int b) {
        b -= a;
        return (int) (Math.random() * ++b) + a;
    }

    private static void testTree() {

        Tree<Integer> tree = new MyTreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);

        System.out.println("Root is 60: " + tree.find(60));
        System.out.println("Find 70: " + tree.find(70));
        System.out.println("Find 31: " + tree.find(31));
        System.out.println("Find 555: " + tree.find(555));

        tree.traverse(Tree.TraverseMode.IN_ORDER);


    }
}
