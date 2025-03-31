package IKM;

public class Child extends Parent {
    public Child(){count++;}

    public static void main(String[] args) {
        System.out.println(getCount());
        Child child = new Child();
        System.out.println(getCount());
    }
}
