import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.DecimalFormat;

class MainFrame extends JFrame {
Container c;
JButton btnAdd, btnView, btnExp;
JLabel lblT, lblCon;

MainFrame() {
c = getContentPane();
c.setBackground(Color.decode("#28df99"));
setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
Font f = new Font("Verdana", Font.BOLD, 24);
Font f1 = new Font("Verdana", Font.BOLD, 40);


lblT = new JLabel("BMI Calculator");		lblT.setFont(f1);		lblT.setAlignmentX(Component.CENTER_ALIGNMENT);			lblT.setForeground(Color.BLACK);	lblT.setBackground(Color.WHITE);	lblT.setOpaque(true);
btnAdd = new JButton("Calculate BMI");	btnAdd.setFont(f);		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);		
btnView = new JButton("View History");	btnView.setFont(f);		btnView.setAlignmentX(Component.CENTER_ALIGNMENT);
btnExp = new JButton("Export Data");		btnExp.setFont(f);		btnExp.setAlignmentX(Component.CENTER_ALIGNMENT);
lblCon = new JLabel("Count is ");		lblCon.setFont(f);		lblCon.setAlignmentX(Component.CENTER_ALIGNMENT);			lblCon.setForeground(Color.BLACK);	lblCon.setBackground(Color.WHITE);	lblCon.setOpaque(true);

btnAdd.setForeground(Color.BLACK);
btnAdd.setBackground(Color.WHITE);	
btnAdd.setBorderPainted(false);
btnAdd.setFocusPainted(false);

btnView.setForeground(Color.BLACK);
btnView.setBackground(Color.WHITE);	
btnView.setBorderPainted(false);
btnView.setFocusPainted(false);

btnExp.setForeground(Color.BLACK);
btnExp.setBackground(Color.WHITE);	
btnExp.setBorderPainted(false);
btnExp.setFocusPainted(false);

ActionListener a1 = (ae) -> {
AddFrame a = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {
ViewFrame a = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
try {
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI", "root", "abc456");
System.out.println("Connected");

String sql = "select f1()";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
JOptionPane.showMessageDialog(new JDialog(), "Backup taken successfully");
con.close();
System.out.println("Closed");
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
};
btnExp.addActionListener(a3);


int no = 0;
try {
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI", "root", "abc456");
System.out.println("Connected");

String sql = "select f()";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();

no = rs.getInt(1);
con.close();
System.out.println("Closed");
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}

lblCon.setText("Count is " + no);

c.add(Box.createVerticalStrut(100));
c.add(lblT);
c.add(Box.createVerticalStrut(40));
c.add(btnAdd);
c.add(Box.createVerticalStrut(40));
c.add(btnView);
c.add(Box.createVerticalStrut(40));
c.add(btnExp);
c.add(Box.createVerticalStrut(40));
c.add(lblCon);

setTitle("BMI Calculator");
setSize(1000, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
