import java.util.Random;

class MyClass implements Runnable {
    private Random rnd;
    private String str;

    public MyClass(String str) {
        this.str = str;
        rnd = new Random();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(rnd.nextInt(2500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + str + " " + i);
        }
    }
    public static void main(String[] args) {
        MyClass mc1 = new MyClass("T 1");
        MyClass mc2 = new MyClass("T 2");

        Thread thread1 = new Thread(mc1, "Wątek 1");
        Thread thread2 = new Thread(mc2, "Wątek 2");

        thread1.start();
        thread2.start();
    }
}