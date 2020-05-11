import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class ReadEstateDBGUI extends JPanel {
    private TreeMap<Integer, Property> db = new TreeMap<>();
    private void displayDb() {
        System.out.println("=== Printing Database ===");
        for (Map.Entry<Integer, Property> entry : db.entrySet()) {
            Property value = entry.getValue();
            int key = entry.getKey();
            System.out.println("\naddr: " + value.getAddresss() + "\nbr: " + value.getNumOfBedrooms() + "\nsqft: " + value.getSquareFootage() + "\npr: " + value.getPrice() + "\nidx: " + key + "\npropStat: " + value.getStatusOfProperty().toString());
        }
        System.out.println("=========================\n");
    }

    private JLabel transactionLBL = new JLabel("Transaction No: ");
    private JLabel addressLBL = new JLabel("Address:");
    private JLabel bedroomsLBL = new JLabel("Bedrooms:");
    private JLabel squareFootageLBL = new JLabel("Square Footage: ");
    private JLabel priceLBL = new JLabel("Price:");

    private String[] dbOperationsList = {"Insert", "Delete", "Find"};
    private JComboBox dbOperationDropDown = new JComboBox(dbOperationsList);

    private String[] statusList = {"FOR_SALE", "UNDER_CONTRACT", "SOLD"};
    private JComboBox statusListDropDown = new JComboBox(statusList);

    private JTextField transactionField = new JTextField("");
    private JTextField addressField = new JTextField("");
    private JTextField bedroomsField = new JTextField("");
    private JTextField squareFootageField = new JTextField("");
    private JTextField priceField = new JTextField("");

    private JButton processBtn = new JButton("Process");
    ActionListener processOperation = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operation = String.valueOf(dbOperationDropDown.getSelectedItem());

            try {
                switch (operation) {
                    case "Insert":
                        String addr = addressField.getText();
                        int br = Integer.parseInt(bedroomsField.getText());
                        int sqft = Integer.parseInt(squareFootageField.getText());
                        int pr = Integer.parseInt(priceField.getText());

                        Property temp = new Property(addr, br, sqft, pr);
                        db.put(db.size(), temp);
                        displayDb();

                        JOptionPane.showMessageDialog(null, "Successfully Added Property to database");
                        break;
                    case "Find":
                        Integer transId = Integer.parseInt(transactionField.getText());
                        Property req = db.get(transId);
                        System.out.println(req.toString());

                        JOptionPane.showMessageDialog(null, "\naddr: " + req.getAddresss() + "\nbr: " + req.getNumOfBedrooms() + "\nsqft: " + req.getSquareFootage() + "\npr: " + req.getPrice());
                        break;
                    case "Delete":
                        System.out.println("Before:");
                        displayDb();
                        Integer transsId = Integer.parseInt(transactionField.getText());
                        db.remove(transsId);
                        System.out.println("After:");
                        displayDb();

                        JOptionPane.showMessageDialog(null, "Successfully Removed Property from database");
                        break;
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Error Occured");
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
    };

    private JButton changeStatusBtn = new JButton("Change Status");
    ActionListener changeStatusOperation = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String temp = statusListDropDown.getSelectedItem().toString();
                System.out.println("temp = " + temp);
                Status statusListDropDownStatus;

                if (temp.equals("FOR_SALE")) {
                    statusListDropDownStatus = Status.FOR_SALE;
                } else if (temp.equals("UNDER_CONTRACT")) {
                    statusListDropDownStatus = Status.UNDER_CONTRACT;
                } else {
                    statusListDropDownStatus = Status.SOLD;
                }

                Integer transId = Integer.parseInt(transactionField.getText());

                Property propTemp = db.get(transId);
                propTemp.changeState(statusListDropDownStatus);
                db.put(transId, propTemp);

                displayDb();
                JOptionPane.showMessageDialog(null, "Updated status of entry");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error Occured");
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
    };

    public ReadEstateDBGUI() {
        setLayout(new GridLayout(7,2,7,10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(transactionLBL);
        this.add(transactionField);
        this.add(addressLBL);
        this.add(addressField);
        this.add(bedroomsLBL);
        this.add(bedroomsField);
        this.add(squareFootageLBL);
        this.add(squareFootageField);
        this.add(priceLBL);
        this.add(priceField);
        this.add(processBtn);
        this.add(dbOperationDropDown);
        this.add(changeStatusBtn);
        this.add(statusListDropDown);

        changeStatusBtn.addActionListener(changeStatusOperation);
        processBtn.addActionListener(processOperation);
    }
}