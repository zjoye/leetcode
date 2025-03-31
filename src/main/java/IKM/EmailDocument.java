package IKM;

public class EmailDocument extends SendDocument {
    static {
        System.out.println("In Email Document");
    }

    public EmailDocument() {
        System.out.println("Starat to email document");
    }

    {
        System.out.println("Email docment is in process");
    }

    static {
        System.out.println("EmailDocument is completed");
    }
}
