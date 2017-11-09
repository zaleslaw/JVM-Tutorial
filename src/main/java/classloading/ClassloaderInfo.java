package classloading;

public class ClassloaderInfo {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("Loader" + loader);
        System.out.println("Parent loader：" + loader.getParent());
        System.out.println("Parent of the parent：" + loader.getParent().getParent());
    }
}
