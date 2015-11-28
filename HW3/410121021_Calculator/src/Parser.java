import java.util.ArrayList;


public abstract class Parser {

	private ArrayList cmd; 
	private ArrayList<Double> opmd = null; 
	private StringBuffer buffer = new StringBuffer(); 
	private StringBuffer expr = new StringBuffer(); 
	private double result; 
	private Key attribute = null; 
	
	abstract public int parse(); 
	
	public Parser(){
		
	}
	
	public Parser(ArrayList<Key> c){
		
	}
	
}
