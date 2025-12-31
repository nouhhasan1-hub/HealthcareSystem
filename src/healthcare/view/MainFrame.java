package healthcare.view;
import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Healthcare System - MVC Implementation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Patients", new PatientPanel());
        tabs.addTab("Appointments", new JPanel());
        tabs.addTab("Prescriptions", new JPanel());
        tabs.addTab("Referrals", new JPanel());
        
        add(tabs);
        
        JLabel status = new JLabel("Three-Tier Architecture: View → Controller → Model", SwingConstants.CENTER);
        add(status, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
