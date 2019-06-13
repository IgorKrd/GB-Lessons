package Exception;

public class ConverterStringToInt {

    public static int ConvertStringToInt(String[][] myStringArray) throws MyArraySizeException, MyArrayDataException {

        int sumOfArrayElement = 0;

        if (4 != myStringArray.length) throw new MyArraySizeException();

        for (int i = 0; i < myStringArray.length; i++) {

            if (4 != myStringArray[i].length) throw new MyArraySizeException();

            for (int j = 0; j < myStringArray[0].length; j++) {

                try {

                    String s = myStringArray[i][j];
                    int a = Integer.parseInt(s);
                    sumOfArrayElement += a;

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sumOfArrayElement;
    }
}
