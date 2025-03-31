package IKM;

import java.sql.SQLOutput;

public class ProcessDocument extends EmailDocument {
    public static void main(String[] args) {
        System.out.println("Pre process doc before send");
        new ProcessDocument();
        System.out.println("Document has processed and send");
    }
}
