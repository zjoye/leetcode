package IKM;


import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test7 {

    public static void main(String[] args) {
        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> d = x -> System.out.println(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();

    }
}
