public class AnotherThread extends Thread {
    @Override
    public void run() {
        //System.out.println(ThreadColor.ANSI_BLUE + "hello from another thread.");
        System.out.println(ThreadColor.ANSI_BLUE + "hello from ." + currentThread().getName());
        try {
            Thread.sleep(5000);
//            Thread.sleep();
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BLUE + "another thread wake me up");
            return;
        }
        System.out.println(ThreadColor.ANSI_BLUE + "Three seconds have passed and I'am awake.");


    }
}
