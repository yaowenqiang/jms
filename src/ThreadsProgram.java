public class ThreadsProgram {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "hello from the main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "hello from anonymous class thread.");
            }
        }.start();

        System.out.println(ThreadColor.ANSI_GREEN + "hello again from the main thread.");
        //anotherThread.start();

        Thread myRunnableThread  = new Thread(new MyRunnable());
        myRunnableThread.run();

        Thread  myrunnableThread = new 
    }
}
