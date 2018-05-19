package logic;

import java.util.ArrayList;
import java.util.List;

public class Road implements Space{
	
	public int size;
	public Port inputPort, outputPort;
	public ArrayList <Car> listOFcars = new ArrayList <Car>();
	public Direction [] directionList;
	public Orientation orientation;
	public int coordonataLiniePietoni;
	public boolean areLiniePietoni = false;
	public Compartiment compartimente [];
	
	
	public Road(Port inputPort, Port outputPort, int size, Orientation orientation) {
		super();
		this.size = size;
		this.inputPort = inputPort;
		this.outputPort = outputPort;
		this.orientation = orientation;
		
	}

	public void setCompartimente(int cateCompartimente) {
		this.compartimente = new Compartiment[cateCompartimente];
	}










	public void move() {
		
		
	}
}
