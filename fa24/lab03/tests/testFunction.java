import java.io.File;

public class testFunction {

    public static void main(String[] args) {
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());
    }
}
