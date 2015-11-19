import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Main021 extends JFrame {

	private static final long serialVersionUID = 2267977501438441380L;

	DrawPanel drawPanel = new DrawPanel();

	JButton drawBtn = new JButton("Draw");
	JRadioButton colorBtns[] = new JRadioButton[3];
	JTextField numOfShape = new JTextField("1");
	JCheckBox shapeBtns[] = new JCheckBox[3];

	ArrayList<Circle021> listCircle = new ArrayList<Circle021>();
	ArrayList<Rectangle021> listRect = new ArrayList<Rectangle021>();
	ArrayList<Triangle021> listTriangle = new ArrayList<Triangle021>();

	public Main021() {

		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(1, 4));
		String colors[] = { "Red", "Green", "Blue" };
		for (int i = 0; i < colors.length; i++) {
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
		String shapes[] = { "Triangle", "Rectangle", "Circle" };
		for (int i = 0; i < shapes.length; i++) {
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
		JFrame frame = new Main021();
		frame.setSize(650, 550);
		frame.setTitle("410121021 - Midterm");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	class DrawPanel extends JPanel {

		private static final long serialVersionUID = -6584909119399812696L;

		public void toDraw() {
			
			Random r = new Random();
			int tmp; 
			
			for(int i=listTriangle.size()-1; i>=0; i--)
				listTriangle.remove(i); 
			for(int i=listRect.size()-1; i>=0; i--)
				listRect.remove(i); 
			for(int i=listCircle.size()-1; i>=0; i--)
				listCircle.remove(i); 
			
			int num = Integer.parseInt(numOfShape.getText());
			
			int shape[] = {0, 0, 0}; 
			for(int i=0; i<num; i++){
				tmp = r.nextInt(3);
				if(shapeBtns[tmp].isSelected()==false){
					i--; 
					continue; 
				}
				shape[tmp]++; 
			}
			
			for(int i=0; i<shape[0]; i++){
				int arrX[] = new int[3]; 
				int arrY[] = new int[3]; 
				for(int j=0; j<3; j++){
					arrX[j] = r.nextInt(getWidth()); 
					arrY[j] = r.nextInt(getHeight()); 
				} 
				listTriangle.add(new Triangle021(arrX, arrY)); 
			}
			for(int i=0; i<shape[1]; i++){
				int x = r.nextInt(getWidth()); 
				int y = r.nextInt(getHeight());
				int w = r.nextInt(getWidth()/2); 
				int h = r.nextInt(getHeight()/2); 
				listRect.add(new Rectangle021(x, y, w, h)); 
			}
			for(int i=0; i<shape[2]; i++){
				int x = r.nextInt(getWidth()); 
				int y = r.nextInt(getHeight()); 
				int radius = r.nextInt(getHeight()/2); 
				listCircle.add(new Circle021(x, y, radius)); 
			}
			
			repaint();
		}

		public void changeColor() {
			repaint();
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (colorBtns[0].isSelected() == true)
				g.setColor(Color.RED);
			else if (colorBtns[1].isSelected() == true)
				g.setColor(Color.GREEN);
			else if (colorBtns[2].isSelected() == true)
				g.setColor(Color.BLUE);
			else
				g.setColor(Color.BLACK);
		
			for (int i = 0; i < listTriangle.size(); i++) {
				Triangle021 t = new Triangle021(listTriangle.get(i)); 
				g.drawPolygon(t.getX(), t.getY(), 3); 
			}
			for (int i = 0; i < listRect.size(); i++) {
				Rectangle021 r = new Rectangle021(listRect.get(i)); 
				g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight()); 
			}
			for (int i = 0; i < listCircle.size(); i++) {
				Circle021 c = new Circle021(listCircle.get(i)); 
				g.drawOval(c.getX(), c.getY(), c.getRadius(), c.getRadius()); 
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
		public void itemStateChanged(ItemEvent e) {
			String l = ((AbstractButton) e.getItem()).getText();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				for (int i = 0; i < 3; i++) {
					if (colorBtns[i].isSelected() == false)
						continue;
					if (colorBtns[i].getText() == l)
						continue;
					colorBtns[i].setSelected(false);
				}
			}
			drawPanel.changeColor();
		}
	};

}
