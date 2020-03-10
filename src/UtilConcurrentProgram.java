import java.util.Random;
import java.util.concurrent.*;
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html
//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html
//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executor.html


public class UtilConcurrentProgram {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
//        List<String> buffer = new ArrayList<>();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
//        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

//        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
//        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN,bufferLock);
//        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);
//        new Thread(myProducer).start();
//        new Thread(myConsumer1).start();
//        new Thread(myConsumer2).start();

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I am being printed for the callable class");
                return "This is the callable result";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something wnet wrong.");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted.");
        }
        executorService.shutdown();
//        executorService.shutdownNow();
    }
}

class MyProducer implements Runnable {
    public static final String EOF = "EOF";
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + " Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exit...");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    public static final String EOF = "EOF";
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }

            }
        }
    }
}
