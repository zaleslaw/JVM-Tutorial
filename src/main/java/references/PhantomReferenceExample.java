package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

	public static void main(String[] args) {
		Object obj = new Object();
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		PhantomReference<Object> phantom = new PhantomReference<Object>(obj, queue);
		obj = null;
		System.out.println(phantom.get());
		System.gc();
		try {
			Thread.yield();
		} catch (Exception e) {}
		try {
			queue.remove();
		} catch (InterruptedException e) {}
		System.out.println("Done!");
	}
}
