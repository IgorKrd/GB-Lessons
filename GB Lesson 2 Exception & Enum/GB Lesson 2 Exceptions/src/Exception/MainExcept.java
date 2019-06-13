package Exception;

import java.util.Arrays;

public class MainExcept {
    public static void main(String[] args) {

        String[][] myStringArray = {{"39", "12", "22", "76"}, {"65", "79", "45", "69"}, {"77", "69", "30", "51"}, {"99", "32", "74", "45"}};

        System.out.println("We have is Array: ");
        System.out.println();

        System.out.println(Arrays.deepToString(myStringArray));

        try {
            System.out.println();
            System.out.println("Sum of array elements is: ");
            System.out.println(ConverterStringToInt.ConvertStringToInt(myStringArray));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System. err.println(e.getMessage());
        }
    }
}
