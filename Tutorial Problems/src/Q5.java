class TrafficJunction extends Thread {

    private String trafficstatus;
    private int delay;
    TrafficJunction(String trafficstatus, int delay) {
        this.trafficstatus = trafficstatus;
        this.delay = delay;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " - Traffic status: " + trafficstatus
                            + " - Report: " + i);
            try {
                Thread.sleep(delay);
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
public class Q5 {
    public static void main(String[] args) {

        TrafficJunction j1 = new TrafficJunction("Heavy Traffic", 1000);
        TrafficJunction j2 = new TrafficJunction("Moderate Traffic", 1500);
        TrafficJunction j3 = new TrafficJunction("Light Traffic", 2000);

        j1.setName("Junction 1");
        j2.setName("Junction 2");
        j3.setName("Junction 3");

        j1.start();
        j2.start();
        j3.start();
    }
}
