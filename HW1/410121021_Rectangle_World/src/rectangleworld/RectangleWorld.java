package rectangleworld;

import java.io.*; 
import java.util.*; 

public class RectangleWorld {
	//private Rectangle rectangles[] = new ;
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();  
	private int numRectangle; 
	
	// Constructor
	public RectangleWorld(){
		
	}
	
	// To process the input data
	public void readFile() throws IOException {
		String fileName = "rectangle.txt";
		String str; 
		String inStr[]; 
		Double in[] = new Double[6]; 
		Rectangle tmp[];
		
		try{
			FileReader file = new FileReader(fileName);
			BufferedReader fr = new BufferedReader(file);  
			str = fr.readLine(); 
			numRectangle = Integer.parseInt(str);
			tmp = new Rectangle[numRectangle];  
			for(int i=0; i<numRectangle; i++){
				str = fr.readLine();
				inStr = str.split(" "); 
				for(int j=0; j<6; j++){
					in[j] = Double.parseDouble(inStr[j]); 
				}
				tmp[i] = new Rectangle(in[0], in[1], in[2], in[3], in[4], in[5]); 
				rectangles.add(tmp[i]); 
			}
			file.close(); 
		} 
		catch(FileNotFoundException ex){
			ex.printStackTrace(); 
		}
	}

	// Sorting by area
	public void sortByArea(){
		Collections.sort(rectangles); 
	}

	// Detect collision with the largest one
	public void detectCollision(){
		for(Rectangle rec : rectangles){
			if(rec == rectangles.get(0))
				continue; 
			if(rectangles.get(0).detectCollision(rec) == true)
				rectangles.remove(rec); 
		}
	}
	
	// Print the world
	public void printRectangleWorld(){
		for(Rectangle rec : rectangles){
				rec.printRectangle(); 
		}
	}
}
