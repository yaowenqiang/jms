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

        //Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "welcome to anonymous thread.");
            }
        });
        myRunnableThread.start();



        System.out.println(ThreadColor.ANSI_GREEN + "hello again from the main thread.");
        //anotherThread.start();


    }
}
