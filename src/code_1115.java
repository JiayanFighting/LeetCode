import java.util.concurrent.atomic.AtomicBoolean;

public class code_1115 {
    class FooBar {
        private int n;
        private AtomicBoolean first = new AtomicBoolean(true);
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!first.get()){

                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                first.getAndSet(false);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (first.get()){

                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                first.getAndSet(true);
            }
        }
    }
}
