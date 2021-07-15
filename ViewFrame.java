import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.DecimalFormat;

class ViewFrame extends JFrame {
Container c;
TextArea taData;
JButton btnBack;

ViewFrame() {
c = getContentPane();
c.setBackground(Color.WHITE);
setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
Font f = new Font("Verdana", Font.BOLD, 16);

taData = new TextArea(10, 30);		
btnBack = new JButton("Back");	btnBack.setFont(f);		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);	

btnBack.setForeground(Color.BLACK);
btnBack.setBackground(Color.decode("#149c68"));	
btnBack.setBorderPainted(false);
btnBack.setFocusPainted(false);

c.add(taData);
c.add(btnBack);

String data = "";

try {
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI", "root", "abc456");
System.out.println("Connected");

String sql = "select * from Fit";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while (rs.next())
	data = data + "ID = " + rs.getInt(1) + "       Name = " + rs.getString(2) + "        Age= " + rs.getInt(3) + "        Phone Number = " + rs.getInt(4) + "       Gender = " + rs.getString(5) + "         Height = " + rs.getDouble(6) + "         Weight = " + rs.getDouble(7) + "          BMI = " + rs.getDouble(8) +"\n";
con.close();
System.out.println("Closed");
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}

taData.setText(data);

ActionListener a1 = (ae) -> {
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("BMI Calculator");
setSize(1000, 600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
