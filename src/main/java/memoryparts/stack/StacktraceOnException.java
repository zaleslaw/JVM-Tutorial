package memoryparts.stack;

import beans.Department;
import java.util.Arrays;

/**
 * Exception in thread "main" java.lang.StackOverflowError without recursion: change   arr[3] = 184; to arr[30] = 184;
 */
public class StacktraceOnException {
    public static void main(String[] args) {
        int v = 1;
        String s = "First level";
        Department department = new Department("Mobile development");
        f1(v, s, department);

        System.out.println(v + " " + s + " " + department);
    }

    private static void f1(int v, String s, Department department) {
        System.out.println("Method f1 was called");

        int localV = 2;
        v = localV;

        String localS = "Underground";
        s = localS;

        Department localDepartment = new Department("Backend development");

        department = localDepartment; // it's local reference on object, you are erasing passed object on local level
        f2(department);

        System.out.println(department); // you can see here changed object due to changing object with setter
    }

    private static void f2(Department department) {
        System.out.println("Method f2 was called");

        department.setName("Low-level development");
        int[] arr = {1,2,3,4,5};

        f3(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void f3(int[] arr) {
        System.out.println("Method f3 was called");
        arr[3] = 184;
    }
}
