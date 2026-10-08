class FoodDelivery extends Thread {

    FoodDelivery(String name) {
        super(name);
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread: " + getName() + " | Priority: " + getPriority() + " | Activity: " + getActivity());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    String getActivity() {
        if (getName().equals("OrderProcessing"))
            return "Processing customer order";
        else if (getName().equals("DeliveryTracking"))
            return "Tracking delivery location";
        else
            return "Sending order notification";
    }
}
public class FoodDeliveryApp {
    public static void main(String[] args) {
        FoodDelivery order = new FoodDelivery("OrderProcessing");
        FoodDelivery delivery = new FoodDelivery("DeliveryTracking");
        FoodDelivery notification = new FoodDelivery("Notification");
        order.setPriority(10);
        delivery.setPriority(5);
        notification.setPriority(1);

        order.start();
        delivery.start();
        notification.start();
    }
}
