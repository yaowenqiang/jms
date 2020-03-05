public class ThreadsProgram {
    //https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "hello from the main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another Thread = ");
        anotherThread.start();

//        anotherThread.run();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "hello from anonymous class thread.");
            }
        }.start();

        //Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "welcome to anonymous thread.");
                try {
                    anotherThread.join(2000);
                    //anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "Another thread terminated or timed out, so I'am running again.");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all, I was interrupted. ");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();



        System.out.println(ThreadColor.ANSI_GREEN + "hello again from the main thread.");
        //anotherThread.start();


    }
}
