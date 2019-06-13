package Exception;

public class MyArrayDataException extends MyException {

    public MyArrayDataException(int row, int col) {

        super(String.format("NaN! Should parse to int exception in the array[%d, %d]", row, col));
    }
}
