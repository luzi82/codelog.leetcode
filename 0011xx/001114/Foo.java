import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Foo {

    boolean firstDone = false;
    boolean secondDone = false;

    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.firstDone = true;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!firstDone){
          this.wait();
        }
        printSecond.run();
        this.secondDone = true;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(!secondDone){
          this.wait();
        }
        printThird.run();
    }
}
