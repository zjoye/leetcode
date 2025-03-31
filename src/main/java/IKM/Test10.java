package IKM;

public class Test10 {

    void display (){}
    public static void main(String[] args) {
        Long num1 = new Long(1234);
        Long num2 = num1;
        System.out.println(num1 == num2);
        num1++;
        System.out.println(num1 == num2
        );
        Test10 test10 = new Test10();
        test10.display();
    }
}
