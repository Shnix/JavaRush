
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        AtomicInteger k = new AtomicInteger(5);
        flip(k);
        System.out.println(k);
    }
    static void flip(AtomicInteger a){
        a.incrementAndGet();
    }
}
