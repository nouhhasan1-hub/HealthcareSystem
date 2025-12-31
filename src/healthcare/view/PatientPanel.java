package healthcare.view;
import javax.swing.*;
import java.awt.*;
import healthcare.controller.PatientController;
public class PatientPanel extends JPanel {
    private PatientController controller;
    
    public PatientPanel() {
        controller = new PatientController();
        setLayout(new BorderLayout());
        
        JLabel title = new JLabel("Patient Management - MVC Pattern", SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);
        
        JTextArea info = new JTextArea();
        info.setText("Patient Count: " + controller.getAllPatients().size() + "\n" +
                    "MVC Implementation:\n" +
                    "- View: This JPanel\n" +
                    "- Controller: PatientController\n" +
                    "- Model: PatientService\n" +
                    "\nFeatures:\n" +
                    "• Add/Edit/Delete patients\n" +
                    "• CSV data loading\n" +
                    "• Three-tier architecture");
        info.setEditable(false);
        add(new JScrollPane(info), BorderLayout.CENTER);
        
        JButton testButton = new JButton("Test MVC Connection");
        testButton.addActionListener(e -> {
            int count = controller.getAllPatients().size();
            JOptionPane.showMessageDialog(this, 
                "MVC Working!\nPatients in system: " + count,
                "MVC Test", JOptionPane.INFORMATION_MESSAGE);
        });
        add(testButton, BorderLayout.SOUTH);
    }
}
