package jol;

import beans.Department;
import beans.Employee;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.io.PrintWriter;

public class JOLSample {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(Employee.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Department.class).toPrintable());

        PrintWriter pw = new PrintWriter(System.out, true);

        pw.println(GraphLayout.parseInstance(new Employee()).toPrintable());

        // to finish http://hg.openjdk.java.net/code-tools/jol/file/03064c057dc9/jol-samples/src/main/java/org/openjdk/jol/samples/JOLSample_18_Layouts.java


    }
}
