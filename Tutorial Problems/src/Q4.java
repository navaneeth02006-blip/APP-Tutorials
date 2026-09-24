class BankTask implements Runnable {

    private String activity;
    BankTask(String activity) {
        this.activity = activity;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " - " + activity
                            + " - Execution Count: " + i);
            try {
                if (activity.equals("Transaction Processing")) {
                    Thread.sleep(1000);
                }
                else if (activity.equals("Balance Updating")) {
                    Thread.sleep(1500);
                }
                else if (activity.equals("SMS Notification")) {
                    Thread.sleep(2000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
public class Q4 {
    public static void main(String[] args) {

        BankTask transaction = new BankTask("Transaction Processing");
        BankTask balance = new BankTask("Balance Updating");
        BankTask sms = new BankTask("SMS Notification");

        Thread t1 = new Thread(transaction);
        Thread t2 = new Thread(balance);
        Thread t3 = new Thread(sms);

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
