package references;

import java.lang.ref.WeakReference;

public class WeakReferencesExample {

	public static void main(String[] args) {
		Object obj = new Object();
		WeakReference<Object> weak = new WeakReference<>(obj);
		obj = null;
		System.out.println(weak.get());
		System.gc();
		try {
			Thread.yield();
		} catch (Exception e) {}
		System.out.println(weak.get());
	}

}
