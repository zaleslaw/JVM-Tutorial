package references;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferencesExample {

	public static void main(String[] args) {

		List<Integer> softList = new ArrayList<>();
		for(int i = 0; i < 1_000_000_00; i++){
			softList.add(i);
		}

		SoftReference<List<Integer>> soft = new SoftReference<>(softList);

		System.out.println(soft.get().size());
		System.gc();
		try {
			Thread.yield();
		} catch (Exception e) {}
		System.out.println(soft.get().size());
	}

}
