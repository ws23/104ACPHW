package calculator;

import java.awt.*; 
import javax.swing.*; 

public class Main {

	public static void main(String[] args) {
		// Java Frame Setting 
		JFrame calculator = new JFrame(); 
		calculator.setTitle("Calculator - 410121021林育慈"); 
		calculator.setSize(300, 272);
		calculator.setLocationRelativeTo(null); 
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setLayout(new GridBagLayout()); 
		
		
		// Java Panel creation
			// Display Panel
		JPanel displayPanel = new JPanel(); 
		displayPanel.setLayout(new GridBagLayout()); 
		displayPanel.setBorder(BorderFactory.createEmptyBorder(5, 7, 0, 7)); 
			// Button Panel
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridBagLayout()); 
		btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5)); 

		
		// Elements creation
			// Display Area
		JTextField inputField = new JTextField(2); 
		JTextField outputField = new JTextField(5); 
			// Button Area
		JButton numBtns[] = new JButton[10];
		for(int i=0; i<10; i++)
			numBtns[i] = new JButton(Integer.toString(i)); 
		JButton modeBtn = new JButton("Basic"); 
		JButton plusBtn = new JButton("+"); 
		JButton minusBtn = new JButton("-"); 
		JButton multiBtn = new JButton("×"); 
		JButton divBtn = new JButton("÷"); 
		JButton clearBtn = new JButton("C"); 
		JButton equalBtn = new JButton("="); 
		JButton pointBtn = new JButton("."); 
		JButton delBtn = new JButton("←"); 
		
		
		// Grid Layout
			// Panels
		GridBagConstraints panelBags[] = new GridBagConstraints[2];
		for(int i=0; i<2; i++){
			panelBags[i] = new GridBagConstraints(); 
			panelBags[i].gridx = 0; 
			panelBags[i].gridy = i; 
			panelBags[i].gridwidth = 1; 
			panelBags[i].gridheight = 1; 
			panelBags[i].weightx = 1; 
			panelBags[i].weighty = 1; 
			panelBags[i].fill = GridBagConstraints.BOTH; 
			panelBags[i].anchor = GridBagConstraints.CENTER; 
		} 
		calculator.add(displayPanel, panelBags[0]);
		calculator.add(btnPanel, panelBags[1]); 
		
			// Display Area
		GridBagConstraints displayBags[] = new GridBagConstraints[2]; 
		JTextField[] fields = { inputField, outputField };
		Font[] fonts = {
				new Font(Font.MONOSPACED, Font.PLAIN, 22),   
				new Font(Font.MONOSPACED, Font.BOLD, 22)
		}; 
		for(int i=0; i<2; i++){
			displayBags[i] = new GridBagConstraints(); 
			displayBags[i].gridx = 0; 
			displayBags[i].gridy = i; 
			displayBags[i].gridwidth = 1; 
			displayBags[i].gridheight = 1; 
			displayBags[i].weightx = 1; 
			displayBags[i].weighty = 1; 
			displayBags[i].fill = GridBagConstraints.BOTH; 
			displayBags[i].anchor = GridBagConstraints.CENTER; 
			
			fields[i].setFont(fonts[i]); 
			fields[i].setHorizontalAlignment(JTextField.RIGHT); 
			fields[i].setEditable(false); 
			
			displayPanel.add(fields[i], displayBags[i]); 
		}	
			// Button Area
		GridBagConstraints btnBags[] = new GridBagConstraints[19];
			/* arg[][0] = gridx,			  arg[][1] = gridy, 
			 * arg[][2] = gridwidth,   arg[][3] = gridheight */
		int[][] arg = {
				{0, 0, 1, 1}, {1, 0, 1, 1}, {2, 0, 1, 1}, {3, 0, 1, 1}, {4, 0, 1, 1}, 
				{0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {4, 1, 1, 3}, 
				{0, 2, 1, 1}, {1, 2, 1, 1}, {2, 2, 1, 1}, {3, 2, 1, 1}, 
				{0, 3, 2, 1}, 					{2, 3, 1, 1}, {3, 3, 1, 1}, 
				{0, 4, 3, 1}, 										{3, 4, 2, 1}
		};
		JButton[] btns = {
				numBtns[7], numBtns[8], numBtns[9], divBtn, clearBtn, 
				numBtns[4], numBtns[5], numBtns[6], multiBtn, equalBtn, 
				numBtns[1], numBtns[2], numBtns[3], minusBtn, 
				numBtns[0], pointBtn, plusBtn, 
				modeBtn, delBtn
		}; 
		for(int i=0; i<19; i++){
			btnBags[i] = new GridBagConstraints(); 
			btnBags[i].gridx = arg[i][0]; 
			btnBags[i].gridy = arg[i][1]; 
			btnBags[i].gridwidth = arg[i][2]; 
			btnBags[i].gridheight = arg[i][3]; 
			btnBags[i].weightx = 1; 
			btnBags[i].weighty = 1; 
			btnBags[i].fill = GridBagConstraints.BOTH; 
			btnBags[i].anchor = GridBagConstraints.CENTER; 
			
			btns[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 20)); 
			
			btnPanel.add(btns[i], btnBags[i]);
		} 

		// Display Frame
		calculator.setVisible(true);  
	}

}
