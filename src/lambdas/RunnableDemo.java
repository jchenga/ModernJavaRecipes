package lambdas;

public class RunnableDemo {

    public static void main(String[] args) {

        // Use in Java 7 or earlier:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using an anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside runnable using a lambda")).start();

        Runnable r = () -> System.out.println("insdie runnable using a variable");
        new Thread(r).start();
    }
}
