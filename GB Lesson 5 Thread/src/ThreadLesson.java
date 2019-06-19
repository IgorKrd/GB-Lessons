

public class ThreadLesson {

    static final int size = 10000000;
    static final int h = size / 2;

    public float[] calculation(float[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }


    public void methodOne() {

        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();

        calculation(arr);

        System.out.println("MethodOne is ended with following result (Time): " + (System.currentTimeMillis() - a));
    }


    public void methodTwo() {

        float[] arr = new float[size];
        float[] subArrOne = new float[h];
        float[] subArrTwo = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();


        System.arraycopy(arr, 0, subArrOne, 0, h);
        System.arraycopy(arr, h, subArrTwo, 0, h);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculation(subArrOne);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculation(subArrTwo);
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(subArrOne, 0, arr, 0, h);
        System.arraycopy(subArrTwo, 0, arr, h, h);
        System.out.println("MethodTwo is ended with following result (Time): " + (System.currentTimeMillis() - a));
    }


    public static void main(String[] args) {

        ThreadLesson lesson = new ThreadLesson();
        lesson.methodOne();
        lesson.methodTwo();
    }


}
