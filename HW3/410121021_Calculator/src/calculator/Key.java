package calculator;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Key {
	public GridBagConstraints gbc = 
			new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, 
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
					new Insets(0, 0, 0, 0), 0, 0); 
	public Key me; 
	
	public String getKeyName(){
		return ""; 
	}
	
	public GridBagConstraints getGBC(){
		return new GridBagConstraints(); 
	}
	
	public String getName(){
		return ""; 
	}
	
	public Key(){
		
	}	
}
