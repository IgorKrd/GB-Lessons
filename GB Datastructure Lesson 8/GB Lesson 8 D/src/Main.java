public class Main
{
    public static void main( String args[] )
    {
        HashTableByChain table = new HashTableByChain(8);

        table.addElement("apple");
        table.addElement("watermelon");
        table.addElement("plum");
        table.addElement("blueberries");
        table.addElement("pineapple");
        table.addElement("pear");
        table.addElement("apricot");
        table.addElement("cranberries");


        table.printHashTableByChain();

    }
}
