
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashTableByChain {

    private int size;
    private LinkedList<ItemDefinition>[] array;

    @SuppressWarnings("unchecked")
    public HashTableByChain(int size) {
        this.size = size;
        this.array = new LinkedList[size];
        for (int i = 0; i < size; ++i)
            array[i] = new LinkedList<>(); // создаём отдельные списки для каждого индекса в Hash-таблице
    }

    private int hashFunc(ItemDefinition itemDefinition) {
        return hashFunc(itemDefinition.hashCode());
    }

    private int hashFunc(int id) {
        return id % size;
    }


    public boolean addElement(ItemDefinition itemDefinition) {

        int hashValue = hashFunc(itemDefinition);
        return array[hashFunc(hashValue)].add(itemDefinition);

    }

    public boolean removeElement(ItemDefinition itemDefinition) {

        int hashValue = hashFunc(itemDefinition);
        return array[hashValue].remove(itemDefinition);
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            String str = array[i].stream().map(ItemDefinition::toString).collect(Collectors.joining("; ", " List: {", "}"));
            System.out.println(str);
        }
    }

    public int getSize() {
        return Stream.of(array).mapToInt(LinkedList::size).sum();
    }

}
