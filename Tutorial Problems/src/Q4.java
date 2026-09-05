interface Confidential {
}

class Document {
    String name;

    Document(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Document: " + name);
    }
}

class PublicDocument extends Document {
    PublicDocument(String name) {
        super(name);
    }
}

class PrivateDocument extends Document implements Confidential {
    PrivateDocument(String name) {
        super(name);
    }
}

class SecretDocument extends Document implements Confidential {
    SecretDocument(String name) {
        super(name);
    }
}

public class Q4{
    public static void main(String[] args) {

        Document d1 = new PublicDocument("UserGuide.pdf");
        Document d2 = new PrivateDocument("EmployeeDetails.pdf");
        Document d3 = new SecretDocument("CompanySecrets.pdf");

        checkConfidential(d1);
        checkConfidential(d2);
        checkConfidential(d3);
    }

    static void checkConfidential(Document d) {
        d.display();

        if (d instanceof Confidential) {
            System.out.println("Confidential Document");
        } else {
            System.out.println("Non-Confidential Document");
        }

        System.out.println();
    }
}