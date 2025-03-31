package IKM;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.function.Supplier;

public class Test13 {

    public static void main(String[] args) {
        String stringA = "A";
        String stringB = "B";
        String stringnull = null;
        StringBuilder bufferc = new StringBuilder("C");
        Formatter formatter = new Formatter(bufferc);
        formatter.format("%s%s", stringA, stringB);
        System.out.println("" + formatter);

        formatter.format("%-2s",  stringB);
        System.out.println("" + formatter);


        formatter.format("%b", stringnull);
        System.out.println("" + formatter);

        
    }


}