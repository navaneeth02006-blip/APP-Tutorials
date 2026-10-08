import javax.swing.*;
class ServiceModel {
    int calculateCost(boolean general, boolean oil,
                      boolean brake, boolean battery) {
        int cost = 0;
        if (general)
            cost += 1000;
        if (oil)
            cost += 800;
        if (brake)
            cost += 1200;
        if (battery)
            cost += 500;
        return cost;
    }
}
public class VehicleServiceCostEstimator extends JFrame {
    JTextField regField;
    JRadioButton twoWheeler, car;
    JCheckBox general, oil, brake, battery;
    JButton calculateButton;
    JLabel resultLabel;
    ServiceModel model = new ServiceModel();
    VehicleServiceCostEstimator() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(450, 450);
        setLayout(null);

        JLabel regLabel = new JLabel("Registration No:");
        regLabel.setBounds(30, 30, 130, 30);
        add(regLabel);

        regField = new JTextField();
        regField.setBounds(160, 30, 200, 30);
        add(regField);

        JLabel typeLabel = new JLabel("Vehicle Type:");
        typeLabel.setBounds(30, 75, 130, 30);
        add(typeLabel);

        twoWheeler = new JRadioButton("Two Wheeler");
        twoWheeler.setBounds(160, 75, 110, 30);
        add(twoWheeler);

        car = new JRadioButton("Car");
        car.setBounds(270, 75, 70, 30);
        add(car);

        ButtonGroup group = new ButtonGroup();
        group.add(twoWheeler);
        group.add(car);

        JLabel serviceLabel = new JLabel("Select Services:");
        serviceLabel.setBounds(30, 120, 130, 30);
        add(serviceLabel);

        general = new JCheckBox("General Service - Rs.1000");
        general.setBounds(160, 120, 220, 30);
        add(general);

        oil = new JCheckBox("Oil Change - Rs.800");
        oil.setBounds(160, 155, 220, 30);
        add(oil);

        brake = new JCheckBox("Brake Service - Rs.1200");
        brake.setBounds(160, 190, 220, 30);
        add(brake);

        battery = new JCheckBox("Battery Check - Rs.500");
        battery.setBounds(160, 225, 220, 30);
        add(battery);

        calculateButton = new JButton("Calculate Cost");
        calculateButton.setBounds(130, 275, 170, 35);
        add(calculateButton);
        resultLabel = new JLabel("Total Cost: Rs. 0");
        resultLabel.setBounds(130, 330, 200, 30);
        add(resultLabel);

        calculateButton.addActionListener(e -> {
            String registration = regField.getText();
            if (registration.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Registration Number!"
                );
                return;
            }
            if (!twoWheeler.isSelected() && !car.isSelected()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select Vehicle Type!"
                );
                return;
            }
            int total = model.calculateCost(
                    general.isSelected(),
                    oil.isSelected(),
                    brake.isSelected(),
                    battery.isSelected()
            );
            resultLabel.setText(
                    "Total Cost: Rs. " + total
            );
            JOptionPane.showMessageDialog(
                    this,
                    "Registration No: " + registration
                            + "\nTotal Service Cost: Rs. " + total
            );
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new VehicleServiceCostEstimator();
    }
}