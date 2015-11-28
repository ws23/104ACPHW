public abstract class OpKey extends Key{
	protected String name; 
	protected int precedence; 
	protected int numOfOperand;
	protected double[] opmd; // <<Property>>
	
	public abstract double eval(); 
	
	public int getNumOfOperand(){
		return 0; 
	}

	public String getKeyName(){
		return ""; 
	}
	
	public int getPrecedence(){
		return 0; 
	}
	
	public void setOpmd(double[] arg0){
		
	}
	
	public OpKey(String s, int p, int n){
		
	}
}