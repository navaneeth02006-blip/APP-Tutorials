class ExamTask implements Runnable {

    private String activity;
    ExamTask(String activity) {
        this.activity = activity;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " - " + activity
            );
            try {
                if (activity.equals("Displaying Remaining Time")) {
                    Thread.sleep(1000);
                }
                else if (activity.equals("Auto-Saving Student Answers")) {
                    Thread.sleep(2000);
                }
                else if (activity.equals("Checking Network Connection")) {
                    Thread.sleep(1500);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
public class Q3 {
    public static void main(String[] args) {

        ExamTask TimeTask =
                new ExamTask("Displaying Remaining Time");

        ExamTask SaveTask =
                new ExamTask("Auto-Saving Student Answers");

        ExamTask NetworkTask =
                new ExamTask("Checking Network Connection");

        Thread t1 = new Thread(TimeTask);
        Thread t2 = new Thread(SaveTask);
        Thread t3 = new Thread(NetworkTask);

        t1.setName("Timer Thread");
        t2.setName("Auto-Save Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
