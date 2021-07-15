import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.DecimalFormat;

class AddFrame extends JFrame {
Container c;
JLabel lblId, lblName, lblAge, lblPhone, lblGender, lblHg, lblWt, lblans;
JTextField txtId, txtName, txtAge, txtPhone, txtHg, txtWt;
JButton btnSave, btnBack, btnCon;
JRadioButton M, F;

static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
 
        return true;
    }

AddFrame() {
c = getContentPane();
c.setBackground(Color.decode("#28df99"));
setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
Font f = new Font("Verdana", Font.BOLD, 18);
ButtonGroup G = new ButtonGroup();

lblId = new JLabel("Enter ID ");		lblId.setFont(f);		lblId.setAlignmentX(Component.CENTER_ALIGNMENT);			lblId.setForeground(Color.BLACK);
txtId = new JTextField(15);			txtId.setFont(f);		txtId.setAlignmentX(Component.CENTER_ALIGNMENT);			txtId.setMaximumSize( txtId.getPreferredSize() );	
lblName = new JLabel("Enter Name ");		lblName.setFont(f);		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);			lblName.setForeground(Color.BLACK);
txtName = new JTextField(15);		txtName.setFont(f);		txtName.setAlignmentX(Component.CENTER_ALIGNMENT);		txtName.setMaximumSize( txtName.getPreferredSize() );	
lblAge = new JLabel("Enter Age ");		lblAge.setFont(f);		lblAge.setAlignmentX(Component.CENTER_ALIGNMENT);			lblAge.setForeground(Color.BLACK);
txtAge = new JTextField(15);			txtAge.setFont(f);		txtAge.setAlignmentX(Component.CENTER_ALIGNMENT);			txtAge.setMaximumSize( txtAge.getPreferredSize() );	
lblPhone = new JLabel("Enter Phone Number ");	lblPhone.setFont(f);		lblPhone.setAlignmentX(Component.CENTER_ALIGNMENT);		lblPhone.setForeground(Color.BLACK);
txtPhone = new JTextField(15);		txtPhone.setFont(f);	txtPhone.setAlignmentX(Component.CENTER_ALIGNMENT);		txtPhone.setMaximumSize( txtPhone.getPreferredSize() );	
lblGender = new JLabel("Gender ");		lblGender.setFont(f);	lblGender.setAlignmentX(Component.CENTER_ALIGNMENT);		lblGender.setForeground(Color.BLACK);
M = new JRadioButton("Male");		M.setFont(f);		M.setAlignmentX(Component.CENTER_ALIGNMENT);			M.setForeground(Color.BLACK);		
F = new JRadioButton("Female");		F.setFont(f);		F.setAlignmentX(Component.CENTER_ALIGNMENT);			F.setForeground(Color.BLACK);
lblHg = new JLabel("Enter Height in mtr ");	lblHg.setFont(f);		lblHg.setAlignmentX(Component.CENTER_ALIGNMENT);			lblHg.setForeground(Color.BLACK);
txtHg = new JTextField(15);			txtHg.setFont(f);		txtHg.setAlignmentX(Component.CENTER_ALIGNMENT);			txtHg.setMaximumSize( txtHg.getPreferredSize() );	
btnCon = new JButton("Height Converter");	btnCon.setFont(f);		btnCon.setAlignmentX(Component.CENTER_ALIGNMENT);
lblWt = new JLabel("Enter Weight in kg ");	lblWt.setFont(f);		lblWt.setAlignmentX(Component.CENTER_ALIGNMENT);			lblWt.setForeground(Color.BLACK);
txtWt = new JTextField(15);			txtWt.setFont(f);		txtWt.setAlignmentX(Component.CENTER_ALIGNMENT);			txtWt.setMaximumSize( txtWt.getPreferredSize() );	
btnSave = new JButton("Calculate");		btnSave.setFont(f);		btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
lblans = new JLabel("BMI is ");		lblans.setFont(f);		lblans.setAlignmentX(Component.CENTER_ALIGNMENT);			lblans.setForeground(Color.BLACK);	lblans.setBackground(Color.WHITE);	lblans.setOpaque(true);
btnBack = new JButton("Back");		btnBack.setFont(f);		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);	

btnSave.setForeground(Color.BLACK);
btnSave.setBackground(Color.WHITE);	
btnSave.setBorderPainted(false);
btnSave.setFocusPainted(false);

btnBack.setForeground(Color.BLACK);
btnBack.setBackground(Color.WHITE);	
btnBack.setBorderPainted(false);
btnBack.setFocusPainted(false);

btnCon.setForeground(Color.BLACK);
btnCon.setBackground(Color.RED);	
btnCon.setBorderPainted(false);
btnCon.setFocusPainted(false);

M.setOpaque(false);
F.setOpaque(false);

c.add(lblId);
c.add(Box.createVerticalStrut(10));
c.add(txtId);
c.add(Box.createVerticalStrut(10));
c.add(lblName);
c.add(Box.createVerticalStrut(10));
c.add(txtName);
c.add(Box.createVerticalStrut(10));
c.add(lblAge);
c.add(Box.createVerticalStrut(10));
c.add(txtAge);
c.add(Box.createVerticalStrut(10));
c.add(lblPhone);
c.add(Box.createVerticalStrut(10));
c.add(txtPhone);
c.add(Box.createVerticalStrut(10));
c.add(lblGender);
c.add(Box.createVerticalStrut(10));
c.add(M);
c.add(Box.createVerticalStrut(10));
c.add(F);
c.add(Box.createVerticalStrut(10));
c.add(lblHg);
c.add(Box.createVerticalStrut(10));
c.add(txtHg);
c.add(Box.createVerticalStrut(10));
c.add(btnCon);
c.add(Box.createVerticalStrut(10));
c.add(lblWt);
c.add(Box.createVerticalStrut(10));
c.add(txtWt);
c.add(Box.createVerticalStrut(10));
c.add(btnSave);
c.add(Box.createVerticalStrut(10));
c.add(lblans);
c.add(Box.createVerticalStrut(20));
c.add(btnBack);

G.add(M);
G.add(F);

ActionListener a1 = (ae) -> {

MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
try {
DecimalFormat df2 = new DecimalFormat("#.##");

int id =  Integer.parseInt(txtId.getText());
String name = txtName.getText();
int age =  Integer.parseInt(txtAge.getText());
int phone = Integer.parseInt(txtPhone.getText());
double height =  Double.parseDouble(txtHg.getText());
double weight =  Double.parseDouble(txtWt.getText());
String gender = "";
double bmi = 0.0;

if (M.isSelected()) {
   gender = "Male";
} else {
    gender = "Female";
}

bmi = (weight/(height*height));
bmi = Double.parseDouble(df2.format(bmi));

String ans = String.valueOf(bmi);
lblans.setText(ans);


if( id <= 0 ) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid ID"); 
	txtId.setText("");
	lblans.setText("BMI is "); 
} else if(name.length() < 2 || isNumber(name)) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid Name"); 
	txtName.setText("");
	lblans.setText("BMI is "); 
} else if(age <= 0) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid Age"); 
	txtAge.setText(""); 
	lblans.setText("BMI is ");
} else if(phone <=0) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid Phone"); 
	txtPhone.setText(""); 
	lblans.setText("BMI is ");
} else if(height <=0) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid Height"); 
	txtHg.setText(""); 
	lblans.setText("BMI is ");
} else if(weight <=0) {
	JOptionPane.showMessageDialog(new JDialog(), "Invalid Weight"); 
	txtWt.setText(""); 
	lblans.setText("BMI is ");
} else {


try {
//Class.forName("com.mysql.cl.jdbc.Driver");  
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI", "root", "abc456");
System.out.println("Connected");

CallableStatement statement = con.prepareCall("{call BM(?, ?, ?, ?, ?, ?, ?, ?)}");

statement.setInt(1, id);
statement.setString(2, name);
statement.setInt(3, age);
statement.setInt(4, phone);
statement.setString(5, gender);
statement.setDouble(6, height);
statement.setDouble(7, weight);
statement.setDouble(8, bmi);

statement.execute();
JOptionPane.showMessageDialog(new JDialog(), "Record added");
txtId.setText("");
txtName.setText("");
txtAge.setText("");
txtPhone.setText("");
txtHg.setText("");
txtWt.setText("");
lblans.setText("BMI is ");
G.clearSelection();
statement.close();
 
con.close();
System.out.println("Closed");
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
}
}
catch( Exception e) {
	JOptionPane.showMessageDialog(new JDialog(), "Please enter proper data"); 
	txtId.setText("");
	txtName.setText("");
	txtAge.setText("");
	txtPhone.setText("");
	txtHg.setText("");
	txtWt.setText("");
	lblans.setText("BMI is ");
	G.clearSelection();
}
};
btnSave.addActionListener(a2);

ActionListener a3 = (ae) -> {
ConFrame a = new ConFrame();
dispose();
};
btnCon.addActionListener(a3);


setTitle("BMI Calculator");
setSize(1000, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
