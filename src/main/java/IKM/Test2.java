package IKM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test2 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2015, 4, 4);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E MMM dd yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
    }
}
