package IKM;


import java.util.Locale;
import java.util.ResourceBundle;

public class Test9 {

    class Parent{

    }
    public static void main(String[] args) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle("Message", new Locale("zh", "CN"));
    }
}
