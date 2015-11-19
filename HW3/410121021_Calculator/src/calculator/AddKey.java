package calculator;

import javax.swing.ImageIcon;

public class AddKey extends OpKey{

	public double eval(){
		return 0; 
	}
	
	public ImageIcon getIcon(){
		return new ImageIcon();
	}
	
	public AddKey(String s, int p, int n) {
		super(s, p, n);
	}
}
