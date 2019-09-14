import java.util.ArrayList;

public class HashTableByChain
{
    private int size;
    private ArrayList[] array;

    public HashTableByChain(int size) {
        this.size = size;
        this.array = new ArrayList[size];
        for (int i = 0; i < size; ++i)
            array[i] = new ArrayList<String>(); // создаём отдельные списки для каждого индекса(ключа)
    }

    private int hashFunc(String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++)
            result += string.charAt(i);  // разбираем строку на символы и на основе их индексов в строке вычисляем Hash-код для неё

        System.out.println("Hash-код для строки: " + string + " -> " + result);
        System.out.println("Результат Hash-функции для данного Hash-кода: " + result % size);
        System.out.println("--------------------------------------------------------");
        System.out.println();

        return result % size;
    }

    @SuppressWarnings("unchecked")
    public void addElement(String string)
    {
        array[hashFunc(string)].add(string);
        // значения 'string' с одиноковыми результатами Hash-функции записываем под одним и тем-же индексом в виде списка
    }


    public void printHashTableByChain()
    {
        System.out.println("Key:   Value: ");
        for (int i = 0; i < size; ++i)
        {
            System.out.print(i + ":     ");
            for (int j = 0; j < array[i].size(); j++)
                System.out.print(array[i].get(j) + "; ");
            System.out.println();
        }
    }
}
