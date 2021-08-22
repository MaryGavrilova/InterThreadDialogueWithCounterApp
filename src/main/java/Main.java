import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task1 = new MyCallable();
        Callable<Integer> task2 = new MyCallable();
        Callable<Integer> task3 = new MyCallable();
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        final ExecutorService pool1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futures = pool1.invokeAll(tasks);
        for (Future<Integer> future : futures) {
            System.out.println("Результат выполнения задачи:" + future.get());
        }
        pool1.shutdown();

        System.out.println("*************************************");

        final ExecutorService pool2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int result = pool2.invokeAny(tasks);
        System.out.println("Результат выполнения задачи:" + result);
        pool2.shutdown();
    }
}
