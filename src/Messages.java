import java.util.Random;
public class Messages {
    public static void main(String[] args) {
        Msg message = new Msg();
        (new Thread(new Write(message))).start();
        (new Thread(new Reader(message))).start();
    }

}

class Msg {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Write implements Runnable {
    private Msg message;

    public Write(Msg message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {
                "Humpty Dumpty set on a wall",
                "Humpty Dumpty had a gread fall",
                "All the king's houses and all the king's man",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {

            }
        }
        message.write("finish");
    }
}

class Reader implements Runnable {
   private Msg message;

    public Reader(Msg message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessages = message.read();!latestMessages.equals("finish");
        latestMessages = message.read()) {
            System.out.println(latestMessages);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}
