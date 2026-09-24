class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public double getConsultationFee() {
        return consultationFee;
    }
    public void displayDoctor() {
        System.out.println("Doctor ID       : " + doctorId);
        System.out.println("Doctor Name     : " + name);
        System.out.println("Specialization  : " + specialization);
        System.out.println("Consultation Fee: Rs." + consultationFee);
    }
}
class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;
    Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }
    public int getAge() {
        return age;
    }
    public void displayPatient() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Disease    : " + disease);
        System.out.println("Age        : " + age);
    }
}
public class Q2 {
    public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Dr. Arun", "Cardiologist", 800);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 600);

        Patient p1 = new Patient(201, "Rahul", "Heart Disease", 45);
        Patient p2 = new Patient(202, "Anu", "Skin Allergy", 25);
        Patient p3 = new Patient(203, "Kiran", "Heart Problem", 50);

        System.out.println("===== HOSPITAL MANAGEMENT SYSTEM =====");
        System.out.println("\n--- Patient 1 ---");
        p1.displayPatient();
        System.out.println("\nTreating Doctor:");
        d1.displayDoctor();
        System.out.println("\n--- Patient 2 ---");
        p2.displayPatient();
        System.out.println("\nTreating Doctor:");
        d2.displayDoctor();
        System.out.println("\n--- Patient 3 ---");
        p3.displayPatient();
        System.out.println("\nTreating Doctor:");
        d1.displayDoctor();

        int patientsOfD1 = 2;
        int patientsOfD2 = 1;

        double totalD1 = patientsOfD1 * d1.getConsultationFee();
        double totalD2 = patientsOfD2 * d2.getConsultationFee();

        System.out.println("\n===== TOTAL CONSULTATION FEE =====");
        System.out.println(d1.getName() + " : Rs." + totalD1);
        System.out.println(d2.getName() + " : Rs." + totalD2);
    }
}
