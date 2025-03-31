package IKM;

public class Test14 {

    static int num2 = getValue();
    static int num1 = 10;

    static int getValue() {
        return num1;
    }

    static int doSum() {
        return num1 + num2;
    }

    static int doMin() {
        return num1 - num2;
    }

    public static void main(String[] args) {
        System.out.println(doSum());
        System.out.println(doMin());
    }


}