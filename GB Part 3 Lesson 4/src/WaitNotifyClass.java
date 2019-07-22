public class WaitNotifyClass {

    private final Object monitor = new Object();

    private volatile char currentLetter = 'A';

    public static void main(String[] args) {

        WaitNotifyClass wnc = new WaitNotifyClass();


        Thread t1A = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printA();
            }
        });

        Thread t2B = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printB();
            }
        });

        Thread t3C = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printC();
            }
        });


        t1A.start();
        t2B.start();
        t3C.start();

    }

    void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A')
                        monitor.wait();
                    System.out.print(" A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B')
                        monitor.wait();
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C')
                        monitor.wait();
                    System.out.print("C ");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
