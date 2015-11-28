import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CalcPanel {
	private JTextField display;
	private JTextField expr; 
	private ArrayList cmd; 
	private boolean eqState = false; 
	private boolean advMode = false; 
	private String output; 
	
	ActionListener timerListener = new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			display.setText(output); 
			tm.stop(); 
			// ...Perform a task...
		}
	};
	
	private Timer tm = new Timer(1000, timerListener); 
	private KeyPad kPad; 
	private ArrayList<Key> attribute = new ArrayList<>(); 
	
	protected KeyPad makeKeyPad(){
		return new KeyPad(); 
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	public double getResult(){
		return 0; 
	}
	
	public String getExpression(){
		return ""; 
	}
	
	public CalcPanel(){
		
	}
	
}
