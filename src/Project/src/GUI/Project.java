package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame{

    JFrame jFrame;
    JButton jButton;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JTable jTable;
    DefaultTableModel tableModel;

    Project(){

        // create a new table model and set it to the JTable
        String[] columnNames = {"Task", "Job", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        jTable = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 220, 515, 100);

        jButton = new JButton();
        jButton.setBounds(200,70,110,40);
        jButton.setText("Add Task");
        jButton.setFocusable(false);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Add_Task();
            }
        });

        jButton1 = new JButton();
        jButton1.setText("Add task to Job");
        jButton1.setBounds(175,115, 160,40);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Add_task_to_Job();
            }
        });

        jButton2 = new JButton();
        jButton2.setText("Add Job");
        jButton2.setBounds(193,25,130,40);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Create_Job();
            }
        });

        jButton3 = new JButton();
        jButton3.setText("Scheduling Job");
        jButton3.setBounds(188,160,130,40);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Scheduling_Job();
            }
        });

        // create a new row and add it to the table model



        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(550,380);
        jFrame.setVisible(true);
        jFrame.add(jButton);
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jButton3);
        jFrame.add(jScrollPane);
        jFrame.setTitle("DSA ASSIGNMENT");
    }

    public static void main(String[] args) {
        new Project();
    }
}
