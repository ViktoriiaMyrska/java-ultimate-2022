package onlineTraning;

public class DemoApp {

    public static void main(String[] args) {

        System.out.println("Hello from " + Thread.currentThread().getName());

        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Hello from " + Thread.currentThread().getName());
                }
            }.start();
        }

        Runnable myRunnable =
                new Runnable(){
                    public void run(){
                        System.out.println("Runnable running");
                    }
                };

        Thread thread = new Thread(myRunnable, "New Thread");

        thread.start();
        System.out.println(thread.getName());

        Runnable runnable =
                () -> { System.out.println("Lambda Runnable running"); };

        Thread thread2 = new Thread(runnable, "New Thread");

        thread2.start();
        System.out.println(thread2.getName());

    }

}
