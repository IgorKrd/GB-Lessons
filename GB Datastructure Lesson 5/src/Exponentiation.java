public class Exponentiation {

    public static void main(String[] args) {

        System.out.println(pow(2, -6));
    }

    private static double pow(double x, double y) { // возведение числа 'x' в степень 'y'

        if (y == 1) {
            return x;
        } else if (y == 0) {
            return 1;
        } else if (y < 0) {
            return (1 / (x * pow(x, Math.abs(y) - 1)));
        }
        return x * pow(x, y - 1);
    }
}
