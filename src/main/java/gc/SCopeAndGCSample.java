package gc;

/**
 * -XX:+PrintGC
 */
public class SCopeAndGCSample {

    public static final int SIZE = 6 * 1024 * 1024;

    public void localVarGc1(){
        byte[] bytes = new byte[SIZE];
        System.gc();
    }

    public void localVarGc2(){
        byte[] bytes = new byte[SIZE];
        bytes = null;
        System.gc();
    }

    public void localVarGc3(){
        {
            byte[] bytes = new byte[SIZE];
        }
        System.gc();
    }

    public void localVarGc4(){
        {
            byte[] bytes = new byte[SIZE];
        }
        int a = 4;
        System.gc();
    }

    public void localVarGc5(){
        localVarGc1();
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        SCopeAndGCSample ins = new SCopeAndGCSample();
 //     ins.localVarGc1();
   //   ins.localVarGc2();
     ins.localVarGc3();
  // ins.localVarGc4();
      //  ins.localVarGc5();

        Thread.sleep(10000);


       // For third example
        System.gc();
        Thread.sleep(1000);
    }
}