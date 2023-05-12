import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        int num1, num2, sum;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        num1 = sc.nextInt();
        System.out.print("Введите второе число: ");
        num2 = sc.nextInt();
         sc.close();
        sum = num1 + num2;
        System.out.println("Сумма двух чисел: " + sum);
    }
}