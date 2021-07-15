import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ConFrame extends JFrame {
Container c;
JLabel lblH, lblFeet, lblInch, lblsol;
JTextField txtFeet, txtInch;
JButton btnBack,btnCon;

ConFrame() {
c = getContentPane();
c.setBackground(Color.decode("#28df99"));
setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
Font f = new Font("Verdana", Font.BOLD, 22);

lblH = new JLabel("Enter your Height ");	lblH.setFont(f);		lblH.setAlignmentX(Component.CENTER_ALIGNMENT);		lblH.setForeground(Color.BLACK);
lblFeet = new JLabel("Feet ");			lblFeet.setFont(f);		lblFeet.setAlignmentX(Component.CENTER_ALIGNMENT);		lblFeet.setForeground(Color.BLACK);	
txtFeet = new JTextField(15);			txtFeet.setFont(f);		txtFeet.setAlignmentX(Component.CENTER_ALIGNMENT);		txtFeet.setMaximumSize( txtFeet.getPreferredSize() );	
lblInch = new JLabel("Inches ");		lblInch.setFont(f);		lblInch.setAlignmentX(Component.CENTER_ALIGNMENT);		lblInch.setForeground(Color.BLACK);
txtInch = new JTextField(15);			txtInch.setFont(f);		txtInch.setAlignmentX(Component.CENTER_ALIGNMENT);		txtInch.setMaximumSize( txtInch.getPreferredSize() );				
lblsol = new JLabel("Answer in meters is ");	lblsol.setFont(f);		lblsol.setAlignmentX(Component.CENTER_ALIGNMENT);		lblsol.setForeground(Color.BLACK);	lblsol.setBackground(Color.WHITE);	lblsol.setOpaque(true);
btnCon = new JButton("Convert");		btnCon.setFont(f);		btnCon.setAlignmentX(Component.CENTER_ALIGNMENT);		
btnBack = new JButton("Back");		btnBack.setFont(f);		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);	

btnBack.setForeground(Color.BLACK);
btnBack.setBackground(Color.WHITE);	
btnBack.setBorderPainted(false);
btnBack.setFocusPainted(false);

btnCon.setForeground(Color.BLACK);
btnCon.setBackground(Color.WHITE);	
btnCon.setBorderPainted(false);
btnCon.setFocusPainted(false);


c.add(lblH);
c.add(Box.createVerticalStrut(10));
c.add(lblFeet);
c.add(Box.createVerticalStrut(10));
c.add(txtFeet);
c.add(Box.createVerticalStrut(10));
c.add(lblInch);
c.add(Box.createVerticalStrut(10));
c.add(txtInch);
c.add(Box.createVerticalStrut(20));
c.add(lblsol);
c.add(Box.createVerticalStrut(20));
c.add(btnCon);
c.add(Box.createVerticalStrut(30));
c.add(btnBack);


ActionListener a1 = (ae) -> {
AddFrame a = new AddFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
int feet = Integer.parseInt(txtFeet.getText());
int inches = Integer.parseInt(txtInch.getText());
double sol = 0.0;

sol = (feet + (inches / 12))*(0.3048);
String ans = String.valueOf(sol);
lblsol.setText(ans);
};
btnCon.addActionListener(a2);



setTitle("BMI Calculator");
setSize(1000, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
