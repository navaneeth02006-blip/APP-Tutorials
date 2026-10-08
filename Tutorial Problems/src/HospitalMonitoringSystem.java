class HospitalTask extends Thread {
    public HospitalTask(String name) {
        super(name);
    }
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority());
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is executing task " + i);
        }
    }
}
public class HospitalMonitoringSystem {
    public static void main(String[] args) {
        HospitalTask emergencyAlert = new HospitalTask("EmergencyAlert");
        HospitalTask vitalMonitor =  new HospitalTask("VitalMonitor");
        HospitalTask reportGenerator = new HospitalTask("ReportGenerator");
        emergencyAlert.setPriority(Thread.MAX_PRIORITY);
        vitalMonitor.setPriority(Thread.NORM_PRIORITY);
        reportGenerator.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Hospital Emergency Monitoring System");
        System.out.println("------------------------------------");
        System.out.println(emergencyAlert.getName()+ " Priority: " + emergencyAlert.getPriority());
        System.out.println(vitalMonitor.getName() + " Priority: " + vitalMonitor.getPriority());
        System.out.println(reportGenerator.getName() + " Priority: " + reportGenerator.getPriority());
        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}
