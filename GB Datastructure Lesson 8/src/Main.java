public class Main {
    public static void main(String[] args) {



        //HashTable<ItemDefinition, Integer> hashTable = new MyHashTableImpl<>(5);
        //HashTable<ItemDefinition, Integer> hashTable = new MyDoubleHashTableImpl<>(5);
        HashTableByChain hashTable = new HashTableByChain(5);

        ItemDefinition orange = new ItemDefinition(1, "Orange");
        ItemDefinition banana = new ItemDefinition(71, "Banana");
        ItemDefinition lemon = new ItemDefinition(60, "Lemon");
        ItemDefinition milk = new ItemDefinition(52, "Milk");
        ItemDefinition potato = new ItemDefinition(21, "Potato");

        hashTable.addElement(orange);
        hashTable.addElement(banana);
        hashTable.addElement(lemon);
        hashTable.addElement(milk);
        hashTable.addElement(potato);

        System.out.println("Size is: " + hashTable.getSize());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

        hashTable.display();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

        hashTable.removeElement(banana);

        System.out.println("Size is " + hashTable.getSize());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

        hashTable.display();




//        hashTable.put(orange, 150);
//        hashTable.put(banana, 100);
//        hashTable.put(lemon, 250);
//        hashTable.put(milk, 120);
//        hashTable.put(potato, 67);

//        System.out.println("Size is: " + hashTable.size());
        //System.out.println("Is Full? " + hashTable.isFull());

       // hashTable.display();


    }


}
