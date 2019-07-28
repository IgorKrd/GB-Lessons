public class SomeThingForTestingTwo {

    public static boolean isArrayWithoutOneOrFour(int[] array) {

        int one = 0;
        int four = 0;

        final int arrLen = array.length;

        for (int i = 0; i < arrLen; i++) {
            final int item = array[i];
            if(item != 1 && item !=4) {
                return false;
            }
            if(1 == item) {
                one++;
            }
            if(4 == item) {
                four++;
            }
        }
        return  one > 0 && four > 0;
    }
}
