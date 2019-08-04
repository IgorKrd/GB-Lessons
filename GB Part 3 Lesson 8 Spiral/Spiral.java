
public class Spiral {

    public static void main(String[] args) {

        // задаём размер матрицы (a x b)

        int a = 6;  //высота матрицы
        int b = 7;  //ширина матрицы

        int h = a - 1;  // так как начало отсчёта в массиве начинается от "0", то приводим значения (a) к размерности матрицы
        int w = b - 1; // так как начало отсчёта в массиве начинается от "0", то приводим значения(b) к размерности матрицы

        int c = 0; // счётчик заполняемых элементов
        int i = 0; // счётчик ячейки по вертикали
        int j = 0; // счётчик ячейки по горизонтали
        int p = 0; // счётчик "слоёв" матрицы (прохождение по кругу)


        int[][] mas = new int[a][b];

        while (c != a * b - 1) {  // цикл заполнения ячеек матрицы

            while (j < w) {    // присвоение значений переменной "c" c преинкрементом к ячейкам в строке
                mas[i][j] = ++c;
                j++;
            }

            while (i < h) {    // присвоение значений переменной "c" c преинкрементом к  ячейкам в столбце
                mas[i][j] = ++c;
                i++;
            }

            while (j > p) {
                mas[i][j] = ++c;
                j--;
            }

            //уменьшаем размерность матрицы после прохождения каждого "слоя" по кругу и переходим на новый "слой"
            h--;
            w--;
            p++;

            while (i > p) {
                mas[i][j] = ++c;
                i--;
            }

        }
        //заполняем последний элемент в матрице

        if (c == a * b - 1) {
            mas[i][j] = ++c;
        }

        // выводим матрицу на экран

        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.printf("%4d", mas[i][j]);
            }
            System.out.println();
        }


    }
}