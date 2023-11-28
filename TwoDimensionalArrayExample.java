import java.util.Random;

public class TwoDimensionalArrayExample {
    public static void main(String[] args) {
        int[][] matrix = new int[25][25]; // создание двумерного массива
        Random random = new Random(); // создание генератора случайных чисел
        // заполнение массива случайными числами от 0 до 9
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        // вывод массива на экран
/*        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}