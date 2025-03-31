package IKM;

public class Test15 {

    public static void main(String[] args) {
        Double d = 1.0;
        if (d instanceof Number) {
            d = d++;
        }
        boolean condition1 = d == 2;
        if (condition1) {
            System.out.println("action1");
        }
        double e = 1.0;
        if ((Double) e instanceof Double | d++ == e++) {

            d += d;
        }
        boolean condition2 = d > 2;
        if (condition2) {
            System.out.println("action2");
        }

        boolean condition3 = condition1 ^ condition2;
        if(condition3){
            System.out.println("action3");
        }

    }

}