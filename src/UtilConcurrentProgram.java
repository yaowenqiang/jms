import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html

public class UtilConcurrentProgram {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN,bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        new Thread(myProducer).start();
        new Thread(myConsumer1).start();
        new Thread(myConsumer2).start();
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
                buffer.add(num);
                bufferLock.unlock();;
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exit...");
        bufferLock.lock();;
        buffer.add(EOF);
        bufferLock.unlock();;
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
        while(true) {
            bufferLock.lock();;
            if (buffer.isEmpty()) {
                bufferLock.unlock();;
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                bufferLock.unlock();;
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock();;
        }
    }
}
