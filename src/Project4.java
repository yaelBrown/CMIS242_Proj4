import javax.swing.*;
import java.util.TreeMap;

public class Project4 {
    // db
    private TreeMap<Integer, Property> db = new TreeMap<>();

    // Operations
    private void addProperty(String addr, int br, int sqft, int pr) {
        Property temp = new Property(addr, br, sqft, pr);
        this.db.put(db.size(), temp);
    }

    public static void main(String[] args) {
        JFrame p4 = new JFrame("Real Estate Database");
        p4.setSize(400,315);
        p4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p4.setLocationRelativeTo(null);
        p4.add(new ReadEstateDBGUI());
        p4.setVisible(true);
    }

}