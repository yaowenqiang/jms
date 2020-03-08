import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html
//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Lock.html
//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html

public class UtilConcurrentProgram {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN,bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
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
        }catch (ExecutionException e) {
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
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + " Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();;
                }
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exit...");
        bufferLock.lock();;
        try {
            buffer.add(EOF);
        } finally {
            bufferLock.unlock();;
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    public static final String EOF = "EOF";
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "the counter is " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();;
                }
            } else {
                counter++;
            }
        }
    }
}
