import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
	JFrame jf;
	JLabel displayLabel;
	char operator;
	String num1;
	String num2;
	float result;
	
	
	public Calculator() {
		jf = new JFrame("Calculator"); //object with title
		jf.setLayout(null); //layout
		jf.setSize(600,600); //width and height
		jf.setLocation(500, 200); //where you want locate the layout in the screen
		jf.setVisible(true); //visibility
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Program close when window close
		
		
		//Label
		displayLabel = new JLabel("0");
		displayLabel.setBounds(30, 50, 540, 40);
		displayLabel.setBackground(Color.gray);
		displayLabel.setForeground(Color.white);
		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		jf.add(displayLabel);
		
		
		// Create buttons
		// 1st raw
        JButton sevenButton = new JButton("7");
        sevenButton.setBounds(30, 130, 80, 80);
        sevenButton.setFont(new Font("Arial", Font.PLAIN, 40));
        sevenButton.addActionListener(this);
        jf.add(sevenButton);
        
        JButton eightButton = new JButton("8");
        eightButton.setBounds(130, 130, 80, 80);
        eightButton.setFont(new Font("Arial", Font.PLAIN, 40));
        eightButton.addActionListener(this);
        jf.add(eightButton);
        
        JButton nineButton = new JButton("9");
        nineButton.setBounds(230, 130, 80, 80);
        nineButton.setFont(new Font("Arial", Font.PLAIN, 40));
        nineButton.addActionListener(this);
        jf.add(nineButton);
        
        JButton divButton = new JButton("/");
        divButton.setBounds(330, 130, 80, 80);
        divButton.setFont(new Font("Arial", Font.PLAIN, 40));
        divButton.addActionListener(this);
        jf.add(divButton);
        
        
        // 2nd raw
        JButton fourButton = new JButton("4");
        fourButton.setBounds(30, 230, 80, 80);
        fourButton.setFont(new Font("Arial", Font.PLAIN, 40));
        fourButton.addActionListener(this);
        jf.add(fourButton);
        
        JButton fiveButton = new JButton("5");
        fiveButton.setBounds(130, 230, 80, 80);
        fiveButton.setFont(new Font("Arial", Font.PLAIN, 40));
        fiveButton.addActionListener(this);
        jf.add(fiveButton);
        
        JButton sixButton = new JButton("6");
        sixButton.setBounds(230, 230, 80, 80);
        sixButton.setFont(new Font("Arial", Font.PLAIN, 40));
        sixButton.addActionListener(this);
        jf.add(sixButton);
        
        JButton multiButton = new JButton("*");
        multiButton.setBounds(330, 230, 80, 80);
        multiButton.setFont(new Font("Arial", Font.PLAIN, 40));
        multiButton.addActionListener(this);
        jf.add(multiButton);
        
        
        // 3rd raw
        JButton oneButton = new JButton("1");
        oneButton.setBounds(30, 330, 80, 80);
        oneButton.setFont(new Font("Arial", Font.PLAIN, 40));
        oneButton.addActionListener(this);
        jf.add(oneButton);
        
        JButton twoButton = new JButton("2");
        twoButton.setBounds(130, 330, 80, 80);
        twoButton.setFont(new Font("Arial", Font.PLAIN, 40));
        twoButton.addActionListener(this);
        jf.add(twoButton);
        
        JButton threeButton = new JButton("3");
        threeButton.setBounds(230, 330, 80, 80);
        threeButton.setFont(new Font("Arial", Font.PLAIN, 40));
        threeButton.addActionListener(this);
        jf.add(threeButton);
        
        JButton subButton = new JButton("-");
        subButton.setBounds(330, 330, 80, 80);
        subButton.setFont(new Font("Arial", Font.PLAIN, 40));
        subButton.addActionListener(this);
        jf.add(subButton);
        
        // 4th raw
        JButton dotButton = new JButton(".");
        dotButton.setBounds(30, 430, 80, 80);
        dotButton.setFont(new Font("Arial", Font.PLAIN, 40));
        dotButton.addActionListener(this);
        jf.add(dotButton);
        
        JButton zeroButton = new JButton("0");
        zeroButton.setBounds(130, 430, 80, 80);
        zeroButton.setFont(new Font("Arial", Font.PLAIN, 40));
        zeroButton.addActionListener(this);
        jf.add(zeroButton);
        
        JButton equalButton = new JButton("=");
        equalButton.setBounds(230, 430, 80, 80);
        equalButton.setFont(new Font("Arial", Font.PLAIN, 40));
        equalButton.addActionListener(this);
        jf.add(equalButton);
        
        JButton addButton = new JButton("+");
        addButton.setBounds(330, 430, 80, 80);
        addButton.setFont(new Font("Arial", Font.PLAIN, 40));
        addButton.addActionListener(this);
        jf.add(addButton);
        
        JButton ClearButton = new JButton("CLEAR");
        ClearButton.setBounds(430, 430, 100, 80);
        ClearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        ClearButton.addActionListener(this);
        jf.add(ClearButton);
        
	}
	public static void main(String ar[]) {
		new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
        
        // Handle number buttons and decimal point
        if (command.matches("[0-9]|\\.")) {
        	String labelText = displayLabel.getText();
        	displayLabel.setText(labelText + command);
        }else if(command.equals("CLEAR")) {
        	displayLabel.setText("");
        }else if(command.matches("[+\\-*/]")) {
        	String labelText = displayLabel.getText();
        	num1 = labelText;
        	operator = command.charAt(0);
        	displayLabel.setText("");
        }else if(command.equals("=")) {
        	result = 0;
        	String labelText = displayLabel.getText();
        	num2 = labelText;
        	switch (operator) {
            	case '+':
            		result = Float.parseFloat(num1) + Float.parseFloat(num2);
            		break;
            	case '-':
            		result = Float.parseFloat(num1) - Float.parseFloat(num2);
            		break;
            	case '*':
            		result = Float.parseFloat(num1) * Float.parseFloat(num2);
            		break;
            	case '/':
            		if (Float.parseFloat(num2) != 0) {
                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
            		} else {
            			displayLabel.setText("Error");
            			return;
            		}
            		//break;
        	}
        	displayLabel.setText(""+result);
        }
		
	}

}
