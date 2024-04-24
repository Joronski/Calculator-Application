/* Project Made by Recio's Group for MIDTERM WEEK 9 HANDS-ON CODING EXERCISE CCS103 COMPUTER PROGRAMMING 2

Group Members:

Joaquin Aaron P. Recio - Lead Programmer
Anne Galzeleigh L. Eliang - Co-Lead Programmer
Kirsten Joi A. Lazarte - Member 
Jaymart G. Impas - Member
John Henrics L. Mateo - Member
Brenda Lazado - Member
Jennelyn N. Magtibay - Member
Marc Alvin P. Quitorio - Member
Kim Francis O. Dela Cruz - Member
Julius L. Natividad - Member

MIDTERM WEEK 9 HANDS-ON CODING EXERCISE (© 2024 RECIO) */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CalculatorApplication extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDisplay;
	
	private JButton btnNine;
	private JButton btnEight;
	private JButton btnSeven;
	private JButton btnSix;
	private JButton btnFive;
	private JButton btnFour;
	private JButton btnThree;
	private JButton btnTwo;
	private JButton btnOne;
	private JButton btnZero;
	private JButton btnPoint;
	private JButton btnPlusNegative;
	private JButton btnClear;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JButton btnEquals;
	
	// Variables to hold calculator state
	private String currentInput;
	private double result;
	private char operator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApplication frame = new CalculatorApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorApplication() {
		setTitle("Recio's Group Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDisplay = new JLabel("0");
		lblDisplay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDisplay.setBounds(20, 11, 485, 66);
		lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDisplay);
		
		// Initializing calculator state
		currentInput = "";
		result = 0;
		operator = ' ';
		
		// Adding action listeners to buttons
		initializeButtons();
		
		setLocationRelativeTo(null); // JFrame Centered	
	}
	
	// Method to initialize buttons and add some action listeners
	private void initializeButtons() {
		btnNine = new JButton("9");
		btnNine.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNine.setBounds(20, 88, 89, 66);
		btnNine.addActionListener(this);
		contentPane.add(btnNine);
		
		btnEight = new JButton("8");
		btnEight.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEight.setBounds(119, 88, 89, 66);
		btnEight.addActionListener(this);
		contentPane.add(btnEight);
		
		btnSeven = new JButton("7");
		btnSeven.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSeven.setBounds(218, 88, 89, 66);
		btnSeven.addActionListener(this);
		contentPane.add(btnSeven);
		
		btnSix = new JButton("6");
		btnSix.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSix.setBounds(20, 165, 89, 66);
		btnSix.addActionListener(this);
		contentPane.add(btnSix);
		
		btnFive = new JButton("5");
		btnFive.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFive.setBounds(119, 165, 89, 66);
		btnFive.addActionListener(this);
		contentPane.add(btnFive);
		
		btnFour = new JButton("4");
		btnFour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFour.setBounds(218, 165, 89, 66);
		btnFour.addActionListener(this);
		contentPane.add(btnFour);
		
		btnThree = new JButton("3");
		btnThree.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnThree.setBounds(20, 242, 89, 66);
		btnThree.addActionListener(this);
		contentPane.add(btnThree);
		
		btnTwo = new JButton("2");
		btnTwo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTwo.setBounds(119, 242, 89, 66);
		btnTwo.addActionListener(this);
		contentPane.add(btnTwo);
		
		btnOne = new JButton("1");
		btnOne.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnOne.setBounds(218, 242, 89, 66);
		btnOne.addActionListener(this);
		contentPane.add(btnOne);
		
		btnZero = new JButton("0");
		btnZero.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnZero.setBounds(119, 319, 89, 66);
		btnZero.addActionListener(this);
		contentPane.add(btnZero);
		
		btnPoint = new JButton(".");
		btnPoint.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPoint.setBounds(20, 319, 89, 66);
		btnPoint.addActionListener(this);
		contentPane.add(btnPoint);
		
		btnPlusNegative = new JButton("+/-");
		btnPlusNegative.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlusNegative.setBounds(416, 165, 89, 66);
		btnPlusNegative.addActionListener(this);
		contentPane.add(btnPlusNegative);
		
		btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnClear.setBounds(416, 88, 89, 66);
		btnClear.addActionListener(this);
		contentPane.add(btnClear);
		
		btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlus.setBounds(317, 88, 89, 66);
		btnPlus.addActionListener(this);
		contentPane.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMinus.setBounds(317, 165, 89, 66);
		btnMinus.addActionListener(this);
		contentPane.add(btnMinus);
		
		btnMultiply = new JButton("×");
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMultiply.setBounds(317, 242, 89, 66);
		btnMultiply.addActionListener(this);
		contentPane.add(btnMultiply);
		
		btnDivide = new JButton("÷");
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDivide.setBounds(317, 319, 89, 66);
		btnDivide.addActionListener(this);
		contentPane.add(btnDivide);
		
		btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEquals.setBounds(416, 242, 89, 143);
		btnEquals.addActionListener(this);
		contentPane.add(btnEquals);
	}
	
	public void actionPerformed(ActionEvent e) {
		String btnText = ((JButton) e.getSource()).getText();
		
		// If button is a digit or point
	    if (btnText.matches("[0-9.]")) {
	        // If the button text is a period and the current input already contains a period, do nothing
	        if (btnText.equals(".") && currentInput.contains(".")) {
	            return;
	        }
	        
	        // Check if the current input is an integer or a decimal value
	        if (!currentInput.contains(".") && btnText.equals(".")) {
	            // If the current input does not contain a decimal point and the button text is ".", append it
	            currentInput += btnText;
	        } else if (!currentInput.equals("0") || btnText.equals(".")) {
	            // If the current input is not "0" or the button text is ".", append it
	            currentInput += btnText;
	        }
	        lblDisplay.setText(currentInput);
	    } else if (btnText.matches("[+\\=×÷]")) {
	        // If button is an operator
	        calculateResult();
	        operator = btnText.charAt(0);
	        currentInput = "";
	    } else if (btnText.equals("=")) {
	        // If button is equals
	        calculateResult();
	        operator = ' ';
	    } else if (btnText.equals("C")) {
	        // If button is clear
	        currentInput = "";
	        result = 0;
	        operator = ' ';
	        lblDisplay.setText("0");
	    } else if (btnText.equals("+/-")) {
	        // If button is positive/negative toggle button
	        if (!currentInput.isEmpty()) {
	            double num = Double.parseDouble(currentInput);
	            num = -num; // Toggle sign
	            currentInput = String.valueOf(num);
	            lblDisplay.setText(currentInput);
	        }
	    }
	}
	
	// Method to perform calculation based on current input and operator
	private void calculateResult() {
		if (!currentInput.isEmpty()) {
			double input = Double.parseDouble(currentInput);
			switch (operator) {
				case '+':
					result += input;
					break;
				case '-':
					result -= input;
					break;
				case '×':
					result *= input;
					break;
				case '÷':
					if (input != 0) {
						result /= input;
					} else {
						lblDisplay.setText("Error");
					}
					break;
				default:
					result = input;
			}
			
			lblDisplay.setText(String.valueOf(result));
			// Check if the result is zero and if the operator is multiplication
	        if (result == 0 && operator == '×') {
	            lblDisplay.setText("0");
	        } else {
	            lblDisplay.setText(String.valueOf(result));
	        }
	        currentInput = "";
		}
	}
}