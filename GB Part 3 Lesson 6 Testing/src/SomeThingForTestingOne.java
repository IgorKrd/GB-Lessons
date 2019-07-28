

import java.util.Arrays;

public class SomeThingForTestingOne {


        public static int[] TakeawayAfterFour (int[] array){
            int n = 0;
            String str = Arrays.toString(array);
            if (str.contains(String.valueOf(4))) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 4) n = i;
                }
                int[] array1 = new int[array.length - n - 1];
                System.arraycopy(array, n + 1, array1, 0, array1.length);
                return array1;
            } else {
                throw new RuntimeException("'4' не найдена!");
            }
        }
    }
