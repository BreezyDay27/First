










public class Example2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable()); // создание нового потока на основе класса MyRunnable
        // Thread thread2 = new Thread(new MyRunnable()); // создание еще одного потока на основе класса MyRunnable
        //extend Thread
        thread3 thread3  = new thread3();


        thread1.start(); // запуск первого потока
   //     thread2.start(); // запуск второго потока
        thread3.start(); // 3 поток

        System.out.println("Main thread is finished"); // вывод сообщения о завершении главного потока
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Это строка номер " + i);
        }

        try {
            Thread.sleep(5000); // приостановка выполнения потока на 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread is finished22 "); // вывод сообщения о завершении потока
    }
}

class thread3 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Это строка номер " + i);
        }



        try {

            Thread.sleep(5000); // приостановка выполнения потока на 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread is finished225"); // вывод сообщения о завершении потока
    }

}