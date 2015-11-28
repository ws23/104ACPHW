import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Calculator {

	private JPanel contentPanel(){
		
		return null;
	}
	
	private CalcPanel calcPanel(){
		
		return null;
	}
	
	public static void main(String[] args) {
		JFrame calculator = new JFrame(); 
		calculator.setTitle("Calculator - 410121021林育慈"); 
		calculator.setSize(300, 272);
		calculator.setLocationRelativeTo(null); 
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setLayout(new GridBagLayout()); 
		//calculator.add(new C3CalcPanel()); //, BorderLayout.CENTER); 
		calculator.setVisible(true); 
	}
	
	public Calculator(){
		
	}

}
