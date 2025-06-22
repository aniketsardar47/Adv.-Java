import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentorAssignmentApp extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton assignButton,b1;
    private List<String> mentors = new ArrayList<>();
    private List<String> groups = new ArrayList<>();
    

    public MentorAssignmentApp() {
        initializeData();
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mentor");
        tableModel.addColumn("Groups & GroupLeaders");
        
        table = new JTable(tableModel);
         b1 = new JButton("Pdf");
        
        assignButton = new JButton("Assign Mentors");
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignMentorsToGroups();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(assignButton);
        assignButton.setBounds(0,320,300,35);
        add(b1);
        b1.setBounds(300,320,300,35);

        setTitle("Mentor Assignment App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
    }

    private void initializeData() {

         mentors.add("Mrs. S.S.Chavhan");
         mentors.add("Mrs. V.M.Aswar");
         mentors.add("Mr. G.R.Sawant");
         mentors.add("Mrs. C.R.Chaudhary");
         mentors.add("Mrs. V.R.Rathod");
         mentors.add("Mr. R.G.Belsare");
         mentors.add("Mrs. S.Rangari");

       
       groups.add("Group 1 -> Jagruti Kaulkar");
       groups.add("Group 2 -> Prashant Sontakke");
       groups.add("Group 3 -> Vedant Tathe");
       groups.add("Group 4 -> Tanay Raundale");
       groups.add("Group 5 -> Anurag Nimkande");
       groups.add("Group 6 -> Pratik Deoke");
       groups.add("Group 7 -> Tanvi Raut");
       groups.add("Group 8 -> Mahir Bajole");
       groups.add("Group 9 -> Arpita Dhage");
       groups.add("Group 10 -> Ayush Dhewale");
       groups.add("Group 11 -> Mayank Udapurkar");
       groups.add("Group 12 -> Sayali Pawar");
       groups.add("Group 13 -> Dwij Chaudhari");
       groups.add("Group 14 -> Renuka Raut");
    }

    private void assignMentorsToGroups() {
        Collections.shuffle(mentors);
         Collections.shuffle(groups);
           
        tableModel.setRowCount(0); // Clear existing rows

        for (int i = 0; i < groups.size(); i++) {
            String group = groups.get(i);
            String mentor = mentors.get(i % mentors.size()); // Assign mentors in a loop

            tableModel.addRow(new Object[]{mentor,group});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MentorAssignmentApp().setVisible(true);
            }
        });
    }
}