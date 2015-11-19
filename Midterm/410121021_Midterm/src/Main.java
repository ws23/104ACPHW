import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class Main extends JFrame{

	private static final long serialVersionUID = 2267977501438441380L;
	DrawPanel drawPanel = new DrawPanel(); 
	JButton drawBtn = new JButton("Draw");
	JRadioButton colorBtns[] = new JRadioButton[3]; 
	JTextField numOfShape = new JTextField("1");
	JCheckBox shapeBtns[] = new JCheckBox[3];  
	
	public Main(){
		
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(1, 4));		
		String colors[] = {"Red", "Green", "Blue"};
		for(int i=0; i<colors.length; i++){
			colorBtns[i] = new JRadioButton(colors[i]);
			colorBtns[i].addItemListener(new ColorListener());
			colorPanel.add(colorBtns[i]); 
		}
		colorBtns[0].setForeground(Color.RED);
		colorBtns[1].setForeground(Color.GREEN);
		colorBtns[2].setForeground(Color.BLUE);
		
		colorBtns[0].setSelected(true);
		JLabel showNoOfShape = new JLabel("No.of Shapes: ");	
		numOfShape.setColumns(6);
		colorPanel.add(showNoOfShape); 
		colorPanel.add(numOfShape); 
		
	
		JPanel shapePanel = new JPanel(); 
		shapePanel.setLayout(new GridLayout(4, 1));		 
		String shapes[] = {"Triangle", "Rectangle", "Circle"};
		for(int i=0; i<shapes.length; i++){
			shapeBtns[i] = new JCheckBox(shapes[i]);
			shapePanel.add(shapeBtns[i]); 
		}
		shapeBtns[0].setSelected(true);
		drawBtn.addActionListener(new DrawListener());
		shapePanel.add(drawBtn); 
		
		this.add(colorPanel, BorderLayout.SOUTH);
		this.add(shapePanel, BorderLayout.EAST);
		drawPanel.setBounds(0, 0, 550, 500); 
		this.add(drawPanel);
			
	}

	public static void main(String[] args) {
		JFrame frame = new Main(); 
		//frame.setResizable(false);
		frame.setSize(650, 550); 
		frame.setTitle("410121021 - Midterm"); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
	}
	
	class DrawPanel extends JPanel {
		      
		/**
		 * 
		 */
		private static final long serialVersionUID = -6584909119399812696L;

		public void toDraw() {
			repaint();
		}
		     
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Random r = new Random();
			
			int num = Integer.parseInt(numOfShape.getText());  
			for(int i=0; i<num; i++){
				int x = r.nextInt(getWidth());
				int y = r.nextInt(getHeight());
				int shape = r.nextInt(3);
				if(shapeBtns[shape].isSelected()==false){
					i--; 
					continue; 
				}
				
				if(colorBtns[0].isSelected()==true){
					g.setColor(Color.RED);
				}
				else if(colorBtns[1].isSelected()==true){
					g.setColor(Color.GREEN); 
				}
				else if(colorBtns[2].isSelected()==true){
					g.setColor(Color.BLUE);
				}
				else{
					g.setColor(Color.BLACK);
				}
				
				if(shape==0){
					int arrX[] = new int[3]; 
					int arrY[] = new int[3]; 
					for(int j=0; j<3; j++){
						arrX[j] = r.nextInt(getWidth()); 
						arrY[j] = r.nextInt(getHeight()); 
					} 
					g.drawPolygon(arrX, arrY, 3);
				}
				else if(shape==1){
					int width = r.nextInt(getWidth()/2); 
					int height = r.nextInt(getHeight()/2); 
					g.drawRect(x, y, width, height);
				}
				else if(shape==2){
					int radius = r.nextInt(getHeight()/2); 
					g.drawOval(x, y, radius, radius);
				}
				else
					System.out.println("Arg Error. "); 
			}
		}
	};  
	
	class DrawListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(new java.util.Date(e.getWhen()));
			if (e.getSource() == drawBtn)
			   drawPanel.toDraw();
		}
	}; 
	
	class ColorListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e){
			drawPanel.toDraw(); 
			String l = ((AbstractButton) e.getItem()).getText(); 
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            for(int i=0; i<3; i++){
	            	if(colorBtns[i].isSelected()==false)
	            		continue; 
	            	if(colorBtns[i].getText()==l)
	            		continue; 
	            	colorBtns[i].setSelected(false); 
	            }
	        }
		}
	}; 
}
