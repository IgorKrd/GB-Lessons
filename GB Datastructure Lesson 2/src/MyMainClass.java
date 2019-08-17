import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyMainClass {

    private static final int ARRAY_CAPACITY = 100;


    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(ARRAY_CAPACITY);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long completeTime = System.nanoTime();
            long durationTime = completeTime - startTime;
            System.out.println(String.format("%s took time: %d microsec. ", actionName, TimeUnit.NANOSECONDS.toMicros(durationTime)));
        };
    }

    public static void main(String[] args) throws InterruptedException {

        Array array1 = new MyArray();
        Array array2 = new MyArray();
        Array array3 = new MyArray();

        randomInitialize(array1, array2, array3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = new ArrayList<>();

        tasks.add(measureTime(array1::sortBubble, "Sort by Bubble"));
        tasks.add(measureTime(array2::sortSelect, "Sort by Select"));
        tasks.add(measureTime(array3::sortInsert, "Sort by Insert"));

        tasks.forEach(executorService::execute);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
