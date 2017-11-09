package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceQueueSample {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue rq = new ReferenceQueue();

        MyDouble pi = new MyDouble("pi", 3.14);
        MyDouble g = new MyDouble("g", 9.8);
        MyDouble e = new MyDouble("e", 2.78);
        // strong reference - line 1
        WeakReference<MyDouble> weakPi = new WeakReference<MyDouble>(pi, rq);

        SoftReference<MyDouble> softG = new SoftReference<MyDouble>(g, rq);
        PhantomReference<MyDouble> phantomE = new PhantomReference<MyDouble>(e, rq);



        System.out.println("In strong times");
        System.out.println(weakPi.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());



        pi = null; // now Counter object is eligible for garbage collection
        g = null;
        e = null;
        System.out.println("After nulling");
        System.out.println(weakPi.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());

        System.gc();
        System.out.println("After GC");
        System.out.println(weakPi.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());
        Thread.sleep(1000);
        System.out.println("RQ: " + rq.poll());
        System.out.println("RQ: " + rq.poll());
        System.out.println("RQ: " + rq.poll());

    }
}

class MyDouble {
    public MyDouble(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    private Double value;
    public String name;

    @Override
    protected void finalize(){
        System.out.println("The " + name + " with " + value + " will be collected!");
    }

    @Override
    public String toString(){
        return this.name + " " + this.value;
    }
}
