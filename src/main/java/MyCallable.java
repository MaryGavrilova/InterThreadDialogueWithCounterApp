import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    static final int NUMBER_OF_ITERATIONS = 5;

    @Override
    public Integer call() {
        int counter = 0;
        try {
            for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
                Thread.sleep(2500);
                System.out.println("Я " + Thread.currentThread().getName() + ". Передаю сообщение " + (i + 1));
                counter++;
            }
        } catch (InterruptedException err) {
            System.out.println("Выполнение " + Thread.currentThread().getName() + " было приостановлено во время сна.");
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return counter;
    }
}
