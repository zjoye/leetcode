package IKM;

import java.util.stream.Stream;

public class Test6 {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("RED", "GREEN", "BLUE", "ORANGE", "BROWN", "VIOLET");
        s.forEach(x ->x.substring(1,2));
    }
}
