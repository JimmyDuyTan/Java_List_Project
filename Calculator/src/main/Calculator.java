package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Calculator implements ActionListener{
	//Declare Instances
	JFrame jFrame;
	JTextField jTextField;
	JButton [] numberButtons = new JButton[10];
	JButton [] functionButtons = new JButton[8];
	JButton addButton,subButton, devButton,mulButton;
	JButton decButton, equaButton,delButton, clearButton;
	JPanel jPanel;
	Font font_text = new Font("Arial", Font.BOLD,30);
	double nums1 = 0,nums2 = 0, answer = 0;
	String err = "Error";
	char operator;
	
	Calculator(){
		jFrame = new JFrame("Calculator");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(420,550);
		jFrame.setLocationRelativeTo(null);
		jFrame.setLayout(null);
		
		jTextField = new JTextField();
		jTextField.setBounds(50, 25, 300, 50);
		jTextField.setFont(font_text);
		jTextField.setEditable(false); //No anyone can edited access
//buttons frame
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		devButton = new JButton("/");
		decButton = new JButton(".");
		equaButton = new JButton("=");
		delButton = new JButton("CE");
		clearButton = new JButton("AC");
//Add button into functionArray
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = devButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equaButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clearButton;
		for(int i = 0;i < 8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font_text);
			functionButtons[i].setFocusable(false);//Focused on button
			functionButtons[i].setBackground(Color.GRAY);
			functionButtons[i].setBorderPainted(false);
			functionButtons[i].setForeground(Color.WHITE);
		}
		//Create these button of numbers
		for(int i = 0;i < 10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font_text);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.GRAY);
			numberButtons[i].setBorderPainted(false);
			numberButtons[i].setForeground(Color.WHITE);
		}
		delButton.setBounds(50, 430, 145, 50);
		clearButton.setBounds(205,430,145,50);
		jPanel = new JPanel();
		jPanel.setBounds(50,100,300,300);
		jPanel.setLayout(new GridLayout(4,4,10,10));
		jPanel.add(numberButtons[7]);
		jPanel.add(numberButtons[8]);
		jPanel.add(numberButtons[9]);
		jPanel.add(addButton);
		jPanel.add(numberButtons[4]);
		jPanel.add(numberButtons[5]);
		jPanel.add(numberButtons[6]);
		jPanel.add(subButton);
		jPanel.add(numberButtons[1]);
		jPanel.add(numberButtons[2]);
		jPanel.add(numberButtons[3]);
		jPanel.add(devButton);
		jPanel.add(decButton);
		jPanel.add(numberButtons[0]);
		jPanel.add(equaButton);
		jPanel.add(mulButton);
		
		jFrame.add(delButton);
		jFrame.add(clearButton);
		jFrame.add(jTextField);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i < numberButtons.length;i++) {
			if(e.getSource() == numberButtons[i]) {
				jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			jTextField.setText(jTextField.getText().concat("."));
			
		}
		if(e.getSource() == addButton) {
			nums1 = Double.parseDouble(jTextField.getText());
			operator = '+';
			jTextField.setText("");
		}
		if(e.getSource() == subButton) {
			nums1 = Double.parseDouble(jTextField.getText());
			operator = '-';
			jTextField.setText("");
		}
		if(e.getSource() == devButton) {
			nums1 = Double.parseDouble(jTextField.getText());
			operator = '/';
			jTextField.setText("");
		}
		if(e.getSource() == mulButton) {
			nums1 = Double.parseDouble(jTextField.getText());
			operator = '*';
			jTextField.setText("");
		}
		if(e.getSource() == equaButton) {
			nums2 = Double.parseDouble(jTextField.getText());
			switch (operator) {
			case '+':
				answer = nums1 + nums2;
				break;
			case '-':
				answer = nums1 - nums2;
				break;
			case '/':
				if(nums2 == 0) {
					answer = 'E';
				}else {
					answer = nums1 / nums2;
				}
				break;
			case '*':
				answer = nums1 * nums2;
				break;	
			}
			if(answer == 'E') {
				nums1 = 0;
				jTextField.setText(err);
			}else {
				jTextField.setText(String.valueOf(answer));
				nums1 = answer;
			}
		}
		if(e.getSource() == clearButton) {
			jTextField.setText("");
		}
		if(e.getSource() == delButton) {
			String string = jTextField.getText();
			jTextField.setText("");
			for(int i = 0;i< string.length() - 1;i++) {
				jTextField.setText(jTextField.getText() + string.charAt(i));
			}
			//Cứ mỗi lần nhấp vào button delete
			//tạo ra biến string lưu toàn bộ giá trị text trong ô textField
			//Đặt textField = rỗng
			//tạo vòng lặp 
			//lặp đến chuỗi có n - 1 ký tự tương tự với việc giảm đi 1 ký tự trong chuỗi
			//đặt lại textFiled = string
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Calculator calc = new Calculator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	
}