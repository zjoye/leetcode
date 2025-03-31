package IKM;

public class Test4 {

    private int data;

    public Test4() {
        this(10);
    }

    public Test4(int data) {
        this.data = data;
    }

    public void display() {
        class Decrementer {
            public void decrement() {
                data--;
            }
        }
        Decrementer decrementer = new Decrementer();
        decrementer.decrement();
        System.out.println("data = " + data);
    }

    public static void main(String[] args) {
        int data = 0;
        Test4 t = new Test4();
        t.display();
        System.out.println("data==" + data);
    }
}
